package com.ceiba.oferta.academica.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;

@Component
public class DaoOfertaAcademicaH2 implements DaoOfertaAcademica{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="OfertaAcademica", value="listar")
    private static String sqlListar;
	
	@SqlStatement(namespace="OfertaAcademica", value="obtenerPorId")
    private static String sqlObtenerPorId;
	

	public DaoOfertaAcademicaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoOfertaAcademica> listar() {
		return  this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoOfertaAcademica());
	}

	@Override
	public OfertaAcademica obtenerPorId(Long ofertaAcademicaId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("ofertaAcademicaId", ofertaAcademicaId);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId, paramSource, new MapeoOfertaAcademicaEntidad());
	}

}
