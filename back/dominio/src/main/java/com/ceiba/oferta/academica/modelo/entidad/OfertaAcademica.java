package com.ceiba.oferta.academica.modelo.entidad;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfertaAcademica {
	
	private String nivelAcademico;

	private Date fechaLimitePago;
	
	private Date fechaExtraordinariaPago;
	
	private double valor;

	public OfertaAcademica(String nivelAcademico, Date fechaLimitePago, Date fechaExtraordinariaPago, double valor) {

		this.nivelAcademico = nivelAcademico;
		this.fechaLimitePago = fechaLimitePago;
		this.fechaExtraordinariaPago = fechaExtraordinariaPago;
		this.valor = valor;
	}
	
	
	
	
}
