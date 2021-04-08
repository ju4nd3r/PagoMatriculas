package com.ceiba.matricula.puerto.repositorio;

import com.ceiba.matricula.modelo.dto.DtoMatricula;

public interface RepositorioMatricula {

	/**
     * Permite crear una Matricula
     * @param matricula
     */
	Long crear(DtoMatricula dtoMatricula);
	
	
}
