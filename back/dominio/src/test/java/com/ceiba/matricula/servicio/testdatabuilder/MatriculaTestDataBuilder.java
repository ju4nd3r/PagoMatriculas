package com.ceiba.matricula.servicio.testdatabuilder;

import com.ceiba.matricula.modelo.entidad.Matricula;

public class MatriculaTestDataBuilder {

	private Long matriculaId;
	
	private Long usuarioId;
	
	private Long ofertaAcademicaId;
	
	private double valor;
	
	
	public MatriculaTestDataBuilder(){
		this.usuarioId = 1L;
		this.ofertaAcademicaId = 1L;
		this.valor = 50000;
	}
	
	public Matricula build(){
		return new Matricula(this.matriculaId, this.usuarioId, this.ofertaAcademicaId, this.valor);
	}
	
}
