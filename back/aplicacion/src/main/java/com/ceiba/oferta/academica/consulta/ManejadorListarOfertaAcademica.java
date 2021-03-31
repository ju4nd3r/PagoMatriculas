package com.ceiba.oferta.academica.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.oferta.academica.modelo.dto.DtoOfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;

@Component
public class ManejadorListarOfertaAcademica {

	private final DaoOfertaAcademica daoOfertaAcademica;

	public ManejadorListarOfertaAcademica(DaoOfertaAcademica daoOfertaAcademica) {
		this.daoOfertaAcademica = daoOfertaAcademica;
	}
	
	public List<DtoOfertaAcademica> ejecutar(){
		return this.daoOfertaAcademica.listar();
	}
}
