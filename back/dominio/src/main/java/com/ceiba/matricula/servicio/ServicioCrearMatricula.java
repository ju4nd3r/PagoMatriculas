package com.ceiba.matricula.servicio;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.dominio.excepcion.ExcepcionFechaVencida;
import com.ceiba.matricula.modelo.dto.DtoMatricula;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.dao.DaoOfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;

public class ServicioCrearMatricula {
	

	
	private final RepositorioMatricula repositorioMatricula;
	

	public ServicioCrearMatricula(RepositorioMatricula repositorioMatricula) {
		super();
		this.repositorioMatricula = repositorioMatricula;
	}
	
	public Long ejecutar(Matricula matricula){
		DtoMatricula dtoMatricula = new DtoMatricula(matricula.getMatriculaId(), 
				matricula.getUsuario().getId(), 
				matricula.getOfertaAcademica().getOfertaAcademicaId(),
				matricula.getValor());
		
		return this.repositorioMatricula.crear(dtoMatricula);
		
	}
	


}
