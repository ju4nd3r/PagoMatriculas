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
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;
import com.ceiba.oferta.academica.servicio.testdatabuilder.OfertaAcademicaTestDataBuilder;

public class ServicioCrearMatriculaTest {

//	@Test
//	public void validarFechaVencimientoTest(){
//		//arrange
//		RepositorioMatricula repositorioMatricula = Mockito.mock(RepositorioMatricula.class);
//		RepositorioOfertaAcademica repositorioOfertaAcademica = Mockito.mock(RepositorioOfertaAcademica.class);
//		
//		Calendar calendario = new GregorianCalendar();
//		calendario.setTime(new Date());
//		calendario.add(Calendar.DAY_OF_YEAR, 3);
//		
//		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaExtraordinariaPago(calendario.getTime()).build();
//		Matricula matricula = new MatriculaTestDataBuilder().build();
//				
//		Mockito.when(repositorioOfertaAcademica.obtenerPorId(Mockito.anyLong())).thenReturn(ofertaAcademica);
//		
//		ServicioCrearMatricula servicioCrearMatricula =  new ServicioCrearMatricula(repositorioMatricula, repositorioOfertaAcademica);
//		
//		//act
//		//assert
//		BasePrueba.assertThrows(() -> servicioCrearMatricula.ejecutar(matricula), ExcepcionFechaVencida.class, "La matricula no se puede efectuar debido a que supera la fecha maxima de pago de la oferta academica" );
//	}
	
	@Test
	public void calculoValorConDescuentoTest(){
		//arrange
		
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, 11);
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaLimitePago(calendario.getTime()).build();
		Matricula matricula = new MatriculaTestDataBuilder().conOfertaAcademica(ofertaAcademica).build();
		
		//act
		double valor = matricula.calcularValorMatricula();
		
		
		//assert
		Assert.assertEquals(8000.0, valor, 0.1);
	}
	
	@Test
	public void calculoValorExtraordinarioTest(){
		//arrange
		
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, -2);
		Date fechaLimitePago = calendario.getTime();
		calendario.add(Calendar.DAY_OF_YEAR, 5);
		Date fechaExtraordinariaPago = calendario.getTime();
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaLimitePago(fechaLimitePago).conFechaExtraordinariaPago(fechaExtraordinariaPago).build();
		Matricula matricula = new MatriculaTestDataBuilder().conOfertaAcademica(ofertaAcademica).build();
		
		//act
		double valor = matricula.calcularValorMatricula();
		
		
		//assert
		Assert.assertEquals(11500.0, valor, 0.1);
	}
	
	@Test
	public void calculoValorSinDescuentoTest(){
		//arrange
		
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, 2);
		Date fechaLimitePago = calendario.getTime();
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaLimitePago(fechaLimitePago).build();
		Matricula matricula = new MatriculaTestDataBuilder().conOfertaAcademica(ofertaAcademica).build();
		
		//act
		double valor = matricula.calcularValorMatricula();
		
		
		//assert
		Assert.assertEquals(10000, valor, 0.1);
	}
	
	
	
}
