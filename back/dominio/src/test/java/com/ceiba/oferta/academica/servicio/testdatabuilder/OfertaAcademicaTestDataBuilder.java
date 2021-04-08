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
	
	private Calendar calendario;
	
	public OfertaAcademicaTestDataBuilder() {
		this.nivelAcademico = "primaria";
		calendario = new GregorianCalendar(2021, Calendar.FEBRUARY, 2);
		this.fechaLimitePago = calendario.getTime();
		calendario.add(Calendar.DAY_OF_YEAR, 5);
		this.fechaExtraordinariaPago = calendario.getTime();
		this.valor = 10000;
	}
	
	public OfertaAcademicaTestDataBuilder conFechaExtraordinariaPago(Date fechaExtraordinariaPago){
		this.fechaExtraordinariaPago = fechaExtraordinariaPago;
		return this;
	}
	
	public OfertaAcademicaTestDataBuilder conFechaLimitePago(Date fechaLimitePago){
		this.fechaLimitePago = fechaLimitePago;
		this.calendario.setTime(fechaLimitePago);
		this.calendario.add(Calendar.DAY_OF_YEAR, 5);
		this.fechaExtraordinariaPago = calendario.getTime();
		return this;
	}
	
	public OfertaAcademica build(){
		OfertaAcademica ofertaAcademica = new OfertaAcademica( this.nivelAcademico, this.fechaLimitePago, this.valor);
		ofertaAcademica.setFechaExtraordinariaPago(this.fechaExtraordinariaPago);
		return ofertaAcademica;
	}
}
