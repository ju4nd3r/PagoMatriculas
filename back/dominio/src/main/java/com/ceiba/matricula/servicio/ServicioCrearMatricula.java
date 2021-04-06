package com.ceiba.matricula.servicio;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.dominio.excepcion.ExcepcionFechaVencida;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;

public class ServicioCrearMatricula {
	
	private static final String FECHA_VENCIDA = "La matricula no se puede efectuar debido a que supera la fecha maxima de pago de la oferta";
	private static final int NUMERO_DIAS_ANTES_PARA_APLICAR_DESCUENTO = 10;
	private static final int PORCENTAJE_DESCUENTO_VALOR_MATRICULA = 20;
	private static final int PORCENTAJE_AUMENTO_VALOR_MATRICULA_EXTRAORDINARIA = 15;
	
	
	private final RepositorioMatricula repositorioMatricula;
	
	private final DaoOfertaAcademica daoOfertaAcademica;

	public ServicioCrearMatricula(RepositorioMatricula repositorioMatricula,
			DaoOfertaAcademica daoOfertaAcademica) {
		super();
		this.repositorioMatricula = repositorioMatricula;
		this.daoOfertaAcademica = daoOfertaAcademica;
	}
	
	public Long ejecutar(Matricula matricula){
		System.out.println("ofertaAcademicaId: " + matricula.getOfertaAcademicaId());
		OfertaAcademica ofertaAcademica = daoOfertaAcademica.obtenerPorId(matricula.getOfertaAcademicaId());
		validarFechaVencimiento(ofertaAcademica.getFechaExtraordinariaPago());
		
		matricula.setValor(calcularValorMatricula(ofertaAcademica));
		
		return this.repositorioMatricula.crear(matricula);
		
	}
	
	private void validarFechaVencimiento( Date fechaExtraordinariaPago ){
		Date hoy = new Date();
		if(hoy.before(fechaExtraordinariaPago))
			throw new ExcepcionFechaVencida(FECHA_VENCIDA);

	}
	
	public double calcularValorMatricula(OfertaAcademica ofertaAcademica){
		
		double valorCalculado = ofertaAcademica.getValor();
		Date hoy = new Date();
		
		Calendar calendario = Calendar.getInstance();
        calendario.setTime(hoy);
        
        int count = 0;
        
		while(count < NUMERO_DIAS_ANTES_PARA_APLICAR_DESCUENTO){
			calendario.add(Calendar.DAY_OF_YEAR, 1);
			count++;
		}
		
		if(calendario.getTime().before(ofertaAcademica.getFechaLimitePago())){
			valorCalculado = valorCalculado - valorCalculado*PORCENTAJE_DESCUENTO_VALOR_MATRICULA/100;
			return valorCalculado;
		}
		
		if(hoy.before(ofertaAcademica.getFechaExtraordinariaPago()) && 
				hoy.after(ofertaAcademica.getFechaLimitePago())){
			valorCalculado = valorCalculado + valorCalculado*PORCENTAJE_AUMENTO_VALOR_MATRICULA_EXTRAORDINARIA/100;
			return valorCalculado;
		}
		
		
		
		return valorCalculado;
	}
}
