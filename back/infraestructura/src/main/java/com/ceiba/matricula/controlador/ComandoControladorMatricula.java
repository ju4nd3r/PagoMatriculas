package com.ceiba.matricula.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.matricula.comando.ComandoMatricula;
import com.ceiba.matricula.comando.manejador.ManejadorCrearMatricula;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/matriculas")
@Api(tags = { "Controlador comando matriculas"})
public class ComandoControladorMatricula{

	private final ManejadorCrearMatricula manejadorCrearMatricula;

	@Autowired
	public ComandoControladorMatricula(ManejadorCrearMatricula manejadorCrearMatricula) {
		super();
		this.manejadorCrearMatricula = manejadorCrearMatricula;
	}
	
	@PostMapping
    @ApiOperation("Crear Matriculas")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoMatricula comandoMatricula){
		return this.manejadorCrearMatricula.ejecutar(comandoMatricula);
		
	}


}
