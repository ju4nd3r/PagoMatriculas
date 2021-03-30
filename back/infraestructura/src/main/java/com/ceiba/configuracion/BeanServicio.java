package com.ceiba.configuracion;

import com.ceiba.matricula.puerto.repositorio.RepositorioMatricula;
import com.ceiba.matricula.servicio.ServicioCrearMatricula;
import com.ceiba.oferta.academica.puerto.repositorio.RepositorioOfertaAcademica;
import com.ceiba.oferta.academica.servicio.ServicioCrearOfertaAcademica;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    @Bean
    public ServicioCrearOfertaAcademica servicioCrearOfertaAcademica(RepositorioOfertaAcademica repositorioOfertaAcademica){
    	return new ServicioCrearOfertaAcademica(repositorioOfertaAcademica);
    	
    }
    
    @Bean
    public ServicioCrearMatricula servicioCrearMatricula(RepositorioMatricula repositorioMatricula){
    	return new ServicioCrearMatricula(repositorioMatricula);
    			
    }
}
