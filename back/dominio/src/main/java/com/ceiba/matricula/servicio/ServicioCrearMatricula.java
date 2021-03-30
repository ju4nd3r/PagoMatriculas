package com.ceiba.matricula.servicio;

import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;

public class ServicioCrearMatricula {

	private final RepositorioMatricula repositorioMatricula;

	public ServicioCrearMatricula(RepositorioMatricula repositorioMatricula) {
		super();
		this.repositorioMatricula = repositorioMatricula;
	}
	
	public void ejecutar(Matricula matricula){
		this.repositorioMatricula.crear(matricula);
		
	}
}
