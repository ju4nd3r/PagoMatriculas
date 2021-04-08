package com.ceiba.oferta.academica.servicio;



import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;

public class ServicioCrearOfertaAcademica {

	private final RepositorioOfertaAcademica repositorioOfertaAcademica;
	
	

	public ServicioCrearOfertaAcademica(RepositorioOfertaAcademica repositorioOfertaAcademica) {
		super();
		this.repositorioOfertaAcademica = repositorioOfertaAcademica;
	}
	
	public Long ejecutar(OfertaAcademica ofertaAcademica) {
		
		return this.repositorioOfertaAcademica.crear(ofertaAcademica);
	}
	
	
}
