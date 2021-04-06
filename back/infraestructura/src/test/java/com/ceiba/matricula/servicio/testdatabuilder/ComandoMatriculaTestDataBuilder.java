package com.ceiba.matricula.servicio.testdatabuilder;

import com.ceiba.matricula.comando.ComandoMatricula;

public class ComandoMatriculaTestDataBuilder {

	private Long matriculaId;
	
	private Long usuarioId;
	
	private Long ofertaAcademicaId;
	
	private double valor;
	
	public ComandoMatriculaTestDataBuilder(){
		this.usuarioId = 1L;
		this.ofertaAcademicaId = 1L;
		this.valor = 10000;
		
		
	}
	
	public ComandoMatricula build() {
		return new ComandoMatricula(this.matriculaId, this.usuarioId, this.ofertaAcademicaId, this.valor);
	}
}
