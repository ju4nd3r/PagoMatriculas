package com.ceiba.oferta.academica.servicio;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;
import com.ceiba.oferta.academica.servicio.testdatabuilder.OfertaAcademicaTestDataBuilder;

import static org.junit.Assert.assertEquals;

public class ServicioCrearOfertaAcademicaTest {

	@Test
	public void validarFechaExtraordinariaTest() {
		//arrange
		OfertaAcademica ofertaAcademica = new OfertaAcademicaTestDataBuilder().build();
		RepositorioOfertaAcademica repositorioOfertaAcademica = Mockito.mock(RepositorioOfertaAcademica.class);
		ServicioCrearOfertaAcademica servicioCrearOfertaAcademica = new ServicioCrearOfertaAcademica(repositorioOfertaAcademica);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		//act
		Date fechaExtraordinaria = servicioCrearOfertaAcademica.calcularFechaExtraordinaria(ofertaAcademica.getFechaLimitePago());

		//assert
		assertEquals("08/02/2021", formato.format(fechaExtraordinaria));
	}
}
