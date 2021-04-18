package com.ceiba.matricula.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionFechaVencida;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.matricula.servicio.testdatabuilder.MatriculaTestDataBuilder;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;
import com.ceiba.oferta.academica.servicio.testdatabuilder.OfertaAcademicaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioCrearMatriculaTest {


	
	@Test
	public void calculoValorConDescuentoTest(){
		//arrange
		
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, 11);
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaLimitePago(calendario.getTime()).build();
		Usuario usuario = new UsuarioTestDataBuilder().build();
		
		//act
		Matricula matricula = new Matricula(usuario, ofertaAcademica);
		
		double valor = matricula.getValor();
		
		
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
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().conFechaLimitePago(fechaLimitePago).build();
		Usuario usuario = new UsuarioTestDataBuilder().build();
		
		//act
		Matricula matricula = new Matricula(usuario, ofertaAcademica);
		double valor = matricula.getValor();
		
		
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
		Usuario usuario = new UsuarioTestDataBuilder().build();
		
		//act
		Matricula matricula = new Matricula(usuario, ofertaAcademica);
		double valor = matricula.getValor();
		
		
		//assert
		Assert.assertEquals(10000, valor, 0.1);
	}
	
	@Test
	public void validarMatriculaExistenciaPrevia(){
		// arrange
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.add(Calendar.DAY_OF_YEAR, 2);
		Date fechaLimitePago = calendario.getTime();
		
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder()
				.conFechaLimitePago(fechaLimitePago)
				.build();
		
		Matricula matricula = new MatriculaTestDataBuilder().conOfertaAcademica(ofertaAcademica).build();
		RepositorioMatricula repositorioMatricula = Mockito.mock(RepositorioMatricula.class);
		Mockito.when(repositorioMatricula.existe(Mockito.anyObject(), Mockito.anyObject())).thenReturn(true);
		ServicioCrearMatricula servicioCrearMatricula = new ServicioCrearMatricula(repositorioMatricula);
		// act - assert
		 BasePrueba.assertThrows( () -> servicioCrearMatricula.ejecutar(matricula), 
				 ExcepcionDuplicidad.class, 
				 "El usuario ya esta matriculado a la oferta academica");
	}
	
	
	
}
