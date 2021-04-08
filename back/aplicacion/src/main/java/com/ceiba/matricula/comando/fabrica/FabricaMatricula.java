package com.ceiba.matricula.comando.fabrica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.matricula.comando.ComandoMatricula;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

@Component
public class FabricaMatricula {
	
	@Autowired
	private RepositorioOfertaAcademica repositorioOfertaAcademica;
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	public Matricula crear(ComandoMatricula comandoMatricula){
		
		OfertaAcademica ofertaAcademica = repositorioOfertaAcademica.obtenerPorId(comandoMatricula.getOfertaAcademicaId());
		Usuario usuario = repositorioUsuario.obtenerPorId(comandoMatricula.getUsuarioId());
		
		return new Matricula(
				usuario, ofertaAcademica);
		
	}
}
