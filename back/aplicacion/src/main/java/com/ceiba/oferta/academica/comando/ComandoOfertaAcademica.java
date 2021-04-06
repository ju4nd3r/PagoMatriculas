package com.ceiba.oferta.academica.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoOfertaAcademica {

	private Long ofertaAcademicaId;
	
	private String nivelAcademico;

	private Date fechaLimitePago;
	
	private Date fechaExtraordinariaPago;
	
	private double valor;
}
