package com.ceiba.oferta.academica.puerto.dao;

import java.util.List;

import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;

public interface DaoOfertaAcademica {

	/**
     * Permite listar las ofertas académicas
     * @return las ofertas académicas
     */
    List<DtoOfertaAcademica> listar();
}
