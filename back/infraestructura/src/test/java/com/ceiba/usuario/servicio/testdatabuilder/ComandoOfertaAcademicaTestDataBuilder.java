package com.ceiba.usuario.servicio.testdatabuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import com.ceiba.oferta.academica.comando.ComandoOfertaAcademica;

public class ComandoOfertaAcademicaTestDataBuilder {
	
	
	private String nivelAcademico;

	private Date fechaLimitePago;
	
	private double valor;
	
	public ComandoOfertaAcademicaTestDataBuilder(){
		nivelAcademico = UUID.randomUUID().toString();
		Calendar calendario = new GregorianCalendar(2021, Calendar.FEBRUARY, 2);
		this.fechaLimitePago = calendario.getTime();
	}
	
	public ComandoOfertaAcademicaTestDataBuilder conFechaLimitePago(Date fechaLimitePago){
		this.fechaLimitePago = fechaLimitePago;
		return this;
	}
	
	public ComandoOfertaAcademicaTestDataBuilder conValor(double valor){
		this.valor = valor;
		return this;
	}
	
	public ComandoOfertaAcademica build(){
		return new ComandoOfertaAcademica(
				this.nivelAcademico, this.fechaLimitePago, this.valor);
	}
	
	
}
