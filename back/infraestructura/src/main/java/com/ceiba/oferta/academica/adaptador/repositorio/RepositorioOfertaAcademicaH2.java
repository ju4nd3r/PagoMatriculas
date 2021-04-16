package com.ceiba.oferta.academica.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.oferta.academica.adaptador.dao.MapeoOfertaAcademicaEntidad;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;

@Repository
public class RepositorioOfertaAcademicaH2 implements RepositorioOfertaAcademica{

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	
	
	@SqlStatement(namespace="OfertaAcademica", value="crear")
    private static String sqlCrear;
	
	@SqlStatement(namespace="OfertaAcademica", value="obtenerPorId")
    private static String sqlObtenerPorId;

	public RepositorioOfertaAcademicaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(OfertaAcademica ofertaAcademica) {
		System.out.println("fecha Oferta academica: "+ofertaAcademica.getFechaLimitePago());
		return this.customNamedParameterJdbcTemplate.crear(ofertaAcademica, sqlCrear );
		
	}
	
	@Override
	public OfertaAcademica obtenerPorId(Long ofertaAcademicaId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("ofertaAcademicaId", ofertaAcademicaId);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId, paramSource, new MapeoOfertaAcademicaEntidad());
	}
}
