package com.ceiba.matricula.puerto.repositorio;

import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioMatricula {

	/**
     * Permite crear una Matricula
     * @param matricula
     */
	Long crear(Matricula matricula);
	
	/**
     * Permite validar si existe una matricula con el usuario y ofertaAcademica
     * @param nombre
     * @return si existe o no
     */
    boolean existe(OfertaAcademica ofertaAcademica, Usuario usuario);
	
	
}
