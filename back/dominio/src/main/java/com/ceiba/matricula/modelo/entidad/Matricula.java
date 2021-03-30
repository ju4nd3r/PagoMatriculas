package com.ceiba.matricula.modelo.entidad;

import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;

import lombok.Getter;

@Getter
public class Matricula {

	private Usuario usuario;
	
	private OfertaAcademica ofertaAcademica;

	public Matricula(Usuario usuario, OfertaAcademica ofertaAcademica) {
		this.usuario = usuario;
		this.ofertaAcademica = ofertaAcademica;
	}
	
	
}
