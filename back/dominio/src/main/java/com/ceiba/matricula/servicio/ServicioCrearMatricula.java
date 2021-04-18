package com.ceiba.matricula.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioCrearMatricula {
	
	private static final String EL_USUARIO_YA_ESTA_MATRICULADO_A_LA_OFERTA = "El usuario ya esta matriculado a la oferta academica";
	
	private final RepositorioMatricula repositorioMatricula;
	

	public ServicioCrearMatricula(RepositorioMatricula repositorioMatricula) {
		super();
		this.repositorioMatricula = repositorioMatricula;
	}
	
	public Long ejecutar(Matricula matricula){

		validarExistenciaMatricula(matricula);
		return this.repositorioMatricula.crear(matricula);
		
	}
	
	private void validarExistenciaMatricula(Matricula matricula) {
        boolean existe = this.repositorioMatricula.existe(matricula.getOfertaAcademica() ,matricula.getUsuario());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_ESTA_MATRICULADO_A_LA_OFERTA);
        }
    }


}
