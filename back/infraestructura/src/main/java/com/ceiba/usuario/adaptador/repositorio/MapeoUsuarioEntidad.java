package com.ceiba.usuario.adaptador.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class MapeoUsuarioEntidad implements RowMapper<Usuario>, MapperResult {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");

		return new Usuario(id, nombre);
	}

}
