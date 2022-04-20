package org.springframework.samples.vets;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VetApiTest
{

    @Autowired
    MockMvc mockMvc;

    @Test
    void receive_vets() throws Exception
    {
        mockMvc.perform( get( "/api/v1/vets" ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$", Matchers.not( Matchers.empty() ) ) );
    }

    @Test
    void receive_vets_ensureDouglas() throws Exception
    {
        mockMvc.perform( get( "/api/v1/vets" ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$", Matchers.not( Matchers.empty() ) ) )
                .andExpect( jsonPath( "$[2].id", Matchers.is( 3 ) ) )
                .andExpect( jsonPath( "$[2].lastName", Matchers.is( "Douglas" ) ) )
                .andExpect( jsonPath( "$[2].nrOfSpecialties", Matchers.is( 2 ) ) )
                .andExpect( jsonPath( "$[2].specialties[0].name", Matchers.is( "dentistry" ) ) )
                .andExpect( jsonPath( "$[2].specialties[1].name", Matchers.is( "surgery" ) ) )
        ;
    }
}