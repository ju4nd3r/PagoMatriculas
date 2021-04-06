package com.ceiba.dominio.excepcion;

public class ExcepcionFechaVencida extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ExcepcionFechaVencida(String message) {
        super(message);
    }

}
