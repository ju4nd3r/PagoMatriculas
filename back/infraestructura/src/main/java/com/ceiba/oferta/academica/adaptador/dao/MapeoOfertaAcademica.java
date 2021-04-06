package com.ceiba.oferta.academica.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;

public class MapeoOfertaAcademica implements RowMapper<DtoOfertaAcademica>, MapperResult  {

	@Override
	public DtoOfertaAcademica mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long ofertaAcademicaId = rs.getLong("ofertaAcademicaId");
		String nivelEducativo = rs.getString("nivelAcademico");
		Date fechaLimitePago = rs.getDate("fechaLimitePago");
		Date fechaExtraordinariaPago = rs.getDate("fechaExtraordinariaPago");
		double valor = rs.getDouble("valor");
		return new DtoOfertaAcademica(ofertaAcademicaId, nivelEducativo, fechaLimitePago, fechaExtraordinariaPago, valor);
	}

}
