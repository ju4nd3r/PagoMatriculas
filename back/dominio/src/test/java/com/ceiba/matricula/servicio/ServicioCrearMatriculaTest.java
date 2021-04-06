package com.ceiba.matricula.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionFechaVencida;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.matricula.servicio.testdatabuilder.MatriculaTestDataBuilder;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;
import com.ceiba.oferta.academica.servicio.testdatabuilder.OfertaAcademicaTestDataBuilder;

public class ServicioCrearMatriculaTest {

	@Test
	public void validarFechaVencimientoTest(){
		//arrange
		RepositorioMatricula repositorioMatricula = Mockito.mock(RepositorioMatricula.class);
		DaoOfertaAcademica daoOfertaAcademica = Mockito.mock(DaoOfertaAcademica.class);
		
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, 3);
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaExtraordinariaPago(calendario.getTime()).build();
		Matricula matricula = new MatriculaTestDataBuilder().build();
				
		Mockito.when(daoOfertaAcademica.obtenerPorId(Mockito.anyLong())).thenReturn(ofertaAcademica);
		
		ServicioCrearMatricula servicioCrearMatricula =  new ServicioCrearMatricula(repositorioMatricula, daoOfertaAcademica);
		
		//act
		//assert
		BasePrueba.assertThrows(() -> servicioCrearMatricula.ejecutar(matricula), ExcepcionFechaVencida.class, "La matricula no se puede efectuar debido a que supera la fecha maxima de pago de la oferta" );
	}
	
	@Test
	public void validarCalculoDescuento(){
		//arrange
		RepositorioMatricula repositorioMatricula = Mockito.mock(RepositorioMatricula.class);
		DaoOfertaAcademica daoOfertaAcademica = Mockito.mock(DaoOfertaAcademica.class);
		
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, 11);
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaLimitePago(calendario.getTime()).build();
		ServicioCrearMatricula servicioCrearMatricula = new ServicioCrearMatricula(repositorioMatricula, daoOfertaAcademica);
		
		//act
		double valor = servicioCrearMatricula.calcularValorMatricula(ofertaAcademica);
		
		
		//assert
		Assert.assertEquals(8000.0, valor, 0.1);
	}
	
	
	
	
}
