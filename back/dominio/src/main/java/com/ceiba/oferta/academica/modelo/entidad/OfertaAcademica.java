package com.ceiba.oferta.academica.modelo.entidad;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.dominio.ValidadorArgumento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfertaAcademica {
	
	
	
	private static final String VALOR_DEBE_SER_POSITIVO = "El valor debe ser positivo";

	private static final int CANTIDAD_DIAS_PARA_FECHA_EXTRAORDINARIA = 5;
	
	private Long ofertaAcademicaId;
	
	private String nivelAcademico;

	private Date fechaLimitePago;
	
	private Date fechaExtraordinariaPago;
	
	private double valor;

	public OfertaAcademica( String nivelAcademico, Date fechaLimitePago, double valor) {
		ValidadorArgumento.validarPositivo(valor, VALOR_DEBE_SER_POSITIVO);
		this.nivelAcademico = nivelAcademico;
		this.fechaLimitePago = fechaLimitePago;
		this.fechaExtraordinariaPago = calcularFechaExtraordinaria(fechaLimitePago);
		this.valor = valor;
	}
	
	/**
	 * Calcula la fecha extraordinaria a partir de la fecha limite de pago
	 * @param fechaLimitePago
	 * @return la fecha extraordinaria para ser asignada a la oferta academica
	 */
	public Date calcularFechaExtraordinaria(Date fechaLimitePago) {

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaLimitePago);

        int i = 0;

        while (i < CANTIDAD_DIAS_PARA_FECHA_EXTRAORDINARIA) {

            if (calendario.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                calendario.add(Calendar.DAY_OF_YEAR, 1);
                i++;
            } else {
                calendario.add(Calendar.DAY_OF_YEAR, 1);
            }
        }

        //Si el dia final es domingo, la fecha extraordinaria se aplaza al siguiente dia
        if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendario.add(Calendar.DAY_OF_YEAR, 1);
        }

        return calendario.getTime();
    }
	
	
}
