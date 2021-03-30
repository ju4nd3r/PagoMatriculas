package com.ceiba.oferta.academica.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.oferta.academica.consulta.ManejadorListarOfertaAcademica;
import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ofertas-academicas")
@Api(tags={"Controlador consulta oferta academica"})
public class ConsultaControladorOfertaAcademica {

	private final ManejadorListarOfertaAcademica manejadorListarOfertaAcademica;

	public ConsultaControladorOfertaAcademica(ManejadorListarOfertaAcademica manejadorListarOfertaAcademica) {
		this.manejadorListarOfertaAcademica = manejadorListarOfertaAcademica;
	}
	
	@GetMapping
    @ApiOperation("Listar Ofertas Academicas")
	public List<DtoOfertaAcademica> listar(){
		return this.manejadorListarOfertaAcademica.ejecutar();
	}
	
	
}
