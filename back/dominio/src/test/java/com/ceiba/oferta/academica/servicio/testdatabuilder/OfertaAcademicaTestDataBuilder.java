package com.ceiba.oferta.academica.servicio.testdatabuilder;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;

public class OfertaAcademicaTestDataBuilder {

	private String nivelAcademico;

	private Date fechaLimitePago;
	
	private Date fechaExtraordinariaPago;
	
	private double valor;
	
	public OfertaAcademicaTestDataBuilder() {
		this.nivelAcademico = "primaria";
		Calendar calendario = new GregorianCalendar(2021, Calendar.FEBRUARY, 2);
		this.fechaLimitePago = calendario.getTime();
		this.valor = 10000;
	}
	
	public OfertaAcademicaTestDataBuilder conFechaExtraordinariaPago(Date fechaExtraordinariaPago){
		this.fechaExtraordinariaPago = fechaExtraordinariaPago;
		return this;
	}
	
	public OfertaAcademicaTestDataBuilder conFechaLimitePago(Date fechaLimitePago){
		this.fechaLimitePago = fechaLimitePago;
		return this;
	}
	
	public OfertaAcademica build(){
		return new OfertaAcademica(this.nivelAcademico, this.fechaLimitePago, this.fechaExtraordinariaPago, this.valor);
	}
}
