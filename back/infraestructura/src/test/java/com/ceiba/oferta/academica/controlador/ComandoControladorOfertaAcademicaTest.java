package com.ceiba.oferta.academica.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.oferta.academica.comando.ComandoOfertaAcademica;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoOfertaAcademicaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorOfertaAcademica.class)
public class ComandoControladorOfertaAcademicaTest {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Test
    public void crear() throws Exception {
    	// arrange
    	ComandoOfertaAcademica ofertaAcademica = new ComandoOfertaAcademicaTestDataBuilder().build();
    	
    	//act - assert
    	mocMvc.perform(post("/ofertas-academicas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ofertaAcademica)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

}
