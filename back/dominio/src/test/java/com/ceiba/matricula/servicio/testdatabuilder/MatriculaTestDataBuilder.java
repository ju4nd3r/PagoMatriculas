package com.ceiba.matricula.servicio.testdatabuilder;

import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.servicio.testdatabuilder.OfertaAcademicaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class MatriculaTestDataBuilder {

	private Long matriculaId;
	
	private Usuario usuario;
	
	private OfertaAcademica ofertaAcademica;
	
	private double valor;
	
	
	public MatriculaTestDataBuilder(){
		this.usuario = new UsuarioTestDataBuilder().build();
		this.ofertaAcademica =  new OfertaAcademicaTestDataBuilder().build();
		this.valor = 50000;
	}
	
	public MatriculaTestDataBuilder conOfertaAcademica(OfertaAcademica ofertaAcademica){
		this.ofertaAcademica = ofertaAcademica;
		return this;
	}
	
	public Matricula build() {
		return new Matricula( this.usuario, this.ofertaAcademica);
	}
	
}
