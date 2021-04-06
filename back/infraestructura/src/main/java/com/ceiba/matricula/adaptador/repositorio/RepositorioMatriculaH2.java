package com.ceiba.matricula.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;

@Repository
public class RepositorioMatriculaH2 implements RepositorioMatricula{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="matricula", value="crear")
    private static String sqlCrear;

	public RepositorioMatriculaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Matricula matricula) {
		return this.customNamedParameterJdbcTemplate.crear(matricula, sqlCrear);
		
	}
	
	
}
