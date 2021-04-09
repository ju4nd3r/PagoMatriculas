package com.ceiba.matricula.servicio;


import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;

public class ServicioCrearMatricula {
	

	
	private final RepositorioMatricula repositorioMatricula;
	

	public ServicioCrearMatricula(RepositorioMatricula repositorioMatricula) {
		super();
		this.repositorioMatricula = repositorioMatricula;
	}
	
	public Long ejecutar(Matricula matricula){

		
		return this.repositorioMatricula.crear(matricula);
		
	}
	


}
