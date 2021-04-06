package com.ceiba.oferta.academica.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.oferta.academica.comando.ComandoOfertaAcademica;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;

@Component
public class FabricaOfertaAcademica {

	public OfertaAcademica crear(ComandoOfertaAcademica comandoOfertaAcademica){
		return new OfertaAcademica(comandoOfertaAcademica.getOfertaAcademicaId(),
				comandoOfertaAcademica.getNivelAcademico(),
				comandoOfertaAcademica.getFechaLimitePago(), 
				comandoOfertaAcademica.getFechaExtraordinariaPago(), 
				comandoOfertaAcademica.getValor());
	}
}
