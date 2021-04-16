package com.ceiba.oferta.academica.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.oferta.academica.comando.ComandoOfertaAcademica;
import com.ceiba.oferta.academica.comando.manejador.ManejadorCrearOfertaAcademica;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ofertas-academicas")
@Api(tags = { "Controlador comando ofertas academicas"})
public class ComandoControladorOfertaAcademica {

	private final ManejadorCrearOfertaAcademica manejadorCrearOfertaAcademica;

	@Autowired
	public ComandoControladorOfertaAcademica(ManejadorCrearOfertaAcademica manejadorCrearOfertaAcademica) {

		this.manejadorCrearOfertaAcademica = manejadorCrearOfertaAcademica;
	}
	
	@PostMapping
    @ApiOperation("Crear Oferta Academica")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoOfertaAcademica comandoOfertaAcademica){
		System.out.println("Comando controlador Fecha Limite Pago: " +comandoOfertaAcademica.getFechaLimitePago());
		return this.manejadorCrearOfertaAcademica.ejecutar(comandoOfertaAcademica);
	}
	
	
}
	
