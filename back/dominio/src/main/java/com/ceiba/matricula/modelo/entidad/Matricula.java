package com.ceiba.matricula.modelo.entidad;


import java.util.Calendar;
import java.util.Date;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Matricula {
	
	private static final String FECHA_VENCIDA = "La matricula no se puede efectuar debido a que supera la fecha maxima de pago de la oferta academica";
	private static final String USUARIO_ES_REQUERIDO = "Usuario es requerido";
	private static final String OFERTA_ACADEMICA_ES_REQUERIDA = "Oferta Academica es requerida";
	
	private static final int NUMERO_DIAS_ANTES_PARA_APLICAR_DESCUENTO = 10;
	private static final int PORCENTAJE_DESCUENTO_VALOR_MATRICULA = 20;
	private static final int PORCENTAJE_AUMENTO_VALOR_MATRICULA_EXTRAORDINARIA = 15;

	private Long matriculaId;
	private Usuario usuario;	
	private OfertaAcademica ofertaAcademica;	
	private double valor;

	public Matricula( Usuario usuario,
			OfertaAcademica ofertaAcademica) {
		ValidadorArgumento.validarObligatorio(usuario, USUARIO_ES_REQUERIDO);
		ValidadorArgumento.validarObligatorio(ofertaAcademica, OFERTA_ACADEMICA_ES_REQUERIDA);
		ValidadorArgumento.validarFechaMayorAHoy(ofertaAcademica.getFechaExtraordinariaPago(), FECHA_VENCIDA);
		this.usuario = usuario;
		this.ofertaAcademica = ofertaAcademica;
		this.valor = calcularValorMatricula();
	}
	
	private double calcularValorMatricula(){
		
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
