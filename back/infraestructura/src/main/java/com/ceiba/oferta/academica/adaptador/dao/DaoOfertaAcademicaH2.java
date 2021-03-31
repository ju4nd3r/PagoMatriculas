package com.ceiba.oferta.academica.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;

@Component
public class DaoOfertaAcademicaH2 implements DaoOfertaAcademica{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="oferta_academica", value="listar")
    private static String sqlListar;
	

	public DaoOfertaAcademicaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoOfertaAcademica> listar() {
		return  this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoOfertaAcademica());
	}

}
