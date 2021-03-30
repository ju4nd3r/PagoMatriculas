package com.ceiba.oferta.academica.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoOfertaAcademica {
	
	private String nivelAcademico;

	private Date fechaLimitePago;
	
	private Date fechaExtraordinariaPago;
	
	private double valor;
}
