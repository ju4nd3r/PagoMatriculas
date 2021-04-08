package com.ceiba.oferta.academica.puerto.repositorio;

import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;

public interface RepositorioOfertaAcademica {

	/**
     * Permite crear una oferta Academica
     * @param ofertaAcademica
     */
    Long crear(OfertaAcademica ofertaAcademica);
    
    /**
     * Permite obtener una oferta academica por su id
     * @return la oferta academica
     */
    OfertaAcademica obtenerPorId(Long ofertaAcademicaId);
}
