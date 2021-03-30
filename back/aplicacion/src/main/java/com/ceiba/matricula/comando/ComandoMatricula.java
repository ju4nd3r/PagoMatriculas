package com.ceiba.matricula.comando;



import com.ceiba.oferta.academica.comando.ComandoOfertaAcademica;
import com.ceiba.usuario.comando.ComandoUsuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMatricula {
	
	private ComandoUsuario usuario;

	private ComandoOfertaAcademica ofertaAcademica;
	

}
