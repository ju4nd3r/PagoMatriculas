package com.ceiba.oferta.academica.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;

public class MapeoOfertaAcademicaEntidad implements RowMapper<OfertaAcademica>, MapperResult{

	@Override
	public OfertaAcademica mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String nivelEducativo = rs.getString("nivel_academico");
		Date fechaLimitePago = rs.getDate("fecha_limite_pago");
		Date fechaExtraordinariaPago = rs.getDate("fecha_extraordinaria_pago");
		double valor = rs.getDouble("valor");
		
		return new OfertaAcademica(id, nivelEducativo, fechaLimitePago, fechaExtraordinariaPago, valor);
	}

}
