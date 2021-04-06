package com.ceiba.matricula.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matricula {

	
	private Long matriculaId;
	
	private Long usuarioId;
	
	private Long ofertaAcademicaId;
	
	private double valor;

	public Matricula(Long matriculaId, Long usuarioId, Long ofertaAcademicaId, double valor) {
		this.matriculaId = matriculaId;
		this.usuarioId = usuarioId;
		this.ofertaAcademicaId = ofertaAcademicaId;
		this.valor = valor;
	}
	
	
}
