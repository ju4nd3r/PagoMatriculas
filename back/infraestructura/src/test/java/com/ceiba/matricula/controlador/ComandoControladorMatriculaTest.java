package com.ceiba.matricula.controlador;

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
import com.ceiba.matricula.comando.ComandoMatricula;
import com.ceiba.matricula.servicio.testdatabuilder.ComandoMatriculaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorMatricula.class)
public class ComandoControladorMatriculaTest {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Test
    public void crear() throws Exception {
    	// arrange
    	ComandoMatricula matricula = new ComandoMatriculaTestDataBuilder().build();
    	
    	//act - assert
    	mocMvc.perform(post("/matriculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(matricula)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    	
    }

}
