package com.ceiba.matricula.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMatricula {

	private Long matriculaId;
	
	private Long usuarioId;
	
	private Long ofertaAcademicaId;
	
	private double valor;
	
	
}
