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
		Long ofertaAcademicaId = rs.getLong("ofertaAcademicaId");
		String nivelAcademico = rs.getString("nivelAcademico");
		Date fechaLimitePago = rs.getDate("fechaLimitePago");
		Date fechaExtraordinariaPago = rs.getDate("fechaExtraordinariaPago");
		double valor = rs.getDouble("valor");
		OfertaAcademica ofertaAcademica = new OfertaAcademica( nivelAcademico, fechaLimitePago, valor);
		ofertaAcademica.setFechaExtraordinariaPago(fechaExtraordinariaPago);
		ofertaAcademica.setOfertaAcademicaId(ofertaAcademicaId);
		return ofertaAcademica;
		
	}

}
