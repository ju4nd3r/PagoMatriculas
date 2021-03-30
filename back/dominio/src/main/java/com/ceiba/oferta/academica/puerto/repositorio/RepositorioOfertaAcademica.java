package com.ceiba.oferta.academica.puerto.repositorio;

import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;

public interface RepositorioOfertaAcademica {

	/**
     * Permite crear una oferta Academica
     * @param ofertaAcademica
     */
    void crear(OfertaAcademica ofertaAcademica);
}
