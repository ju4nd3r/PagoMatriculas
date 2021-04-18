package com.ceiba.matricula.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.matricula.modelo.dto.DtoMatricula;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;

@Repository
public class RepositorioMatriculaH2 implements RepositorioMatricula{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="matricula", value="crear")
    private static String sqlCrear;
	
	@SqlStatement(namespace="matricula", value="existe")
    private static String sqlExiste;

	public RepositorioMatriculaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Matricula matricula) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("usuarioId", matricula.getUsuario().getId())
				.addValue("ofertaAcademicaId", matricula.getOfertaAcademica().getOfertaAcademicaId())
				.addValue("valor", matricula.getValor());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, parameterSource,keyHolder,new String[] { "matriculaId" });
		
		return keyHolder.getKey().longValue();
		
	}

	@Override
	public boolean existe(OfertaAcademica ofertaAcademica, Usuario usuario) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("usuarioId", usuario.getId())
				.addValue("ofertaAcademicaId", ofertaAcademica.getOfertaAcademicaId());
		
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}
	
	
}
