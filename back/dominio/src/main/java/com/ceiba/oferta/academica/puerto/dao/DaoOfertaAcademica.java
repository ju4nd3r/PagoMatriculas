package com.ceiba.oferta.academica.puerto.dao;

import java.util.List;

import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;

public interface DaoOfertaAcademica {

	/**
     * Permite listar las ofertas acad�micas
     * @return las ofertas acad�micas
     */
    List<DtoOfertaAcademica> listar();
}
