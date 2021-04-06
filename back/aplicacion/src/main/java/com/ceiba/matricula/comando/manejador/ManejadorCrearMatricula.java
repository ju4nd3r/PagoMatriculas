package com.ceiba.matricula.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.matricula.comando.ComandoMatricula;
import com.ceiba.matricula.comando.fabrica.FabricaMatricula;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.servicio.ServicioCrearMatricula;

@Component
public class ManejadorCrearMatricula  implements ManejadorComandoRespuesta<ComandoMatricula, ComandoRespuesta<Long>>{

	private final FabricaMatricula fabricaMatricula;
	private final ServicioCrearMatricula servicioCrearMatricula;
	
	public ManejadorCrearMatricula(FabricaMatricula fabricaMatricula, ServicioCrearMatricula servicioCrearMatricula) {
		super();
		this.fabricaMatricula = fabricaMatricula;
		this.servicioCrearMatricula = servicioCrearMatricula;
	}
	
	public ComandoRespuesta<Long> ejecutar(ComandoMatricula comandoMatricula){
		Matricula matricula = this.fabricaMatricula.crear(comandoMatricula);
		return new ComandoRespuesta<>(this.servicioCrearMatricula.ejecutar(matricula));
	}
	
}
