package com.ceiba.oferta.academica.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;

@Repository
public class RepositorioOfertaAcademicaH2 implements RepositorioOfertaAcademica{

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="oferta_academica", value="crear")
    private static String sqlCrear;

	public RepositorioOfertaAcademicaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(OfertaAcademica ofertaAcademica) {
		return this.customNamedParameterJdbcTemplate.crear(ofertaAcademica, sqlCrear );
		
	}
	
	
}
