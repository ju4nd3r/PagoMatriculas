package com.ceiba.oferta.academica.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.oferta.academica.comando.ComandoOfertaAcademica;
import com.ceiba.oferta.academica.comando.fabrica.FabricaOfertaAcademica;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.servicio.ServicioCrearOfertaAcademica;

@Component
public class ManejadorCrearOfertaAcademica implements ManejadorComandoRespuesta<ComandoOfertaAcademica, ComandoRespuesta<Long>>{

	private final FabricaOfertaAcademica fabricaOfertaAcademica;
	private final ServicioCrearOfertaAcademica servicioCrearOfertaAcademica;
	
	
	public ManejadorCrearOfertaAcademica(FabricaOfertaAcademica fabricaOfertaAcademica,
			ServicioCrearOfertaAcademica servicioCrearOfertaAcademica) {
		super();
		this.fabricaOfertaAcademica = fabricaOfertaAcademica;
		this.servicioCrearOfertaAcademica = servicioCrearOfertaAcademica;
	}
	
	public ComandoRespuesta<Long> ejecutar(ComandoOfertaAcademica comandoOfertaAcademica) {
		OfertaAcademica ofertaAcademica = this.fabricaOfertaAcademica.crear(comandoOfertaAcademica);
		return new ComandoRespuesta<>(this.servicioCrearOfertaAcademica.ejecutar(ofertaAcademica));
	}
	
	
}
