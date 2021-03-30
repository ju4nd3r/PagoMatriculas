package com.ceiba.matricula.puerto.repositorio;

import com.ceiba.matricula.modelo.entidad.Matricula;

public interface RepositorioMatricula {

	/**
     * Permite crear una Matricula
     * @param matricula
     */
	void crear(Matricula matricula);
}
