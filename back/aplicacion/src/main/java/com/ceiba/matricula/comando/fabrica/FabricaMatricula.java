package com.ceiba.matricula.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.matricula.comando.ComandoMatricula;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;

@Component
public class FabricaMatricula {

	public Matricula crear(ComandoMatricula comandoMatricula){
		
		Usuario usuario = new Usuario(comandoMatricula.getUsuario().getId(), comandoMatricula.getUsuario().getNombre());
		OfertaAcademica ofertaAcademica = new OfertaAcademica(comandoMatricula.getOfertaAcademica().getNivelAcademico(),
				comandoMatricula.getOfertaAcademica().getFechaLimitePago(), 
				comandoMatricula.getOfertaAcademica().getFechaExtraordinariaPago(), 
				comandoMatricula.getOfertaAcademica().getValor());
		
		return new Matricula(usuario, ofertaAcademica);
		
	}
}
