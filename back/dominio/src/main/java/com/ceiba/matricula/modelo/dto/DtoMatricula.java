package com.ceiba.matricula.modelo.dto;

import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMatricula {

	private DtoUsuario usuario;
	
	private DtoOfertaAcademica ofertaAcademica;
	
	
}
