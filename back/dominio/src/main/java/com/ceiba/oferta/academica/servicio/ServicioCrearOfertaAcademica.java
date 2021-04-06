package com.ceiba.oferta.academica.servicio;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;

public class ServicioCrearOfertaAcademica {

	private final RepositorioOfertaAcademica repositorioOfertaAcademica;
	
	private static final int CANTIDAD_DIAS_PARA_FECHA_EXTRAORDINARIA = 5;

	public ServicioCrearOfertaAcademica(RepositorioOfertaAcademica repositorioOfertaAcademica) {
		super();
		this.repositorioOfertaAcademica = repositorioOfertaAcademica;
	}
	
	public Long ejecutar(OfertaAcademica ofertaAcademica) {
		Date fechaExtraordinariaPago = calcularFechaExtraordinaria(ofertaAcademica.getFechaLimitePago());
		ofertaAcademica.setFechaExtraordinariaPago(fechaExtraordinariaPago);
		
		return this.repositorioOfertaAcademica.crear(ofertaAcademica);
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
