package com.ceiba.matricula.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.matricula.comando.ComandoMatricula;
import com.ceiba.matricula.modelo.entidad.Matricula;
import com.ceiba.oferta.academica.modelo.entidad.OfertaAcademica;
import com.ceiba.usuario.modelo.entidad.Usuario;

@Component
public class FabricaMatricula {

	public Matricula crear(ComandoMatricula comandoMatricula){
		
		
		return new Matricula(comandoMatricula.getMatriculaId(),
				comandoMatricula.getUsuarioId(), comandoMatricula.getOfertaAcademicaId(),
				comandoMatricula.getValor());
		
	}
}
