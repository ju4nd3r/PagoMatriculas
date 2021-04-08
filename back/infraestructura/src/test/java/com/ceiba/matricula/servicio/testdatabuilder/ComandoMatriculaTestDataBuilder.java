package com.ceiba.matricula.servicio.testdatabuilder;

import com.ceiba.matricula.comando.ComandoMatricula;

public class ComandoMatriculaTestDataBuilder {

	
	private Long usuarioId;
	
	private Long ofertaAcademicaId;

	
	public ComandoMatriculaTestDataBuilder(){
		this.usuarioId = 1L;
		this.ofertaAcademicaId = 1L;
		
		
	}
	
	public ComandoMatricula build() {
		return new ComandoMatricula( this.usuarioId, this.ofertaAcademicaId);
	}
}
