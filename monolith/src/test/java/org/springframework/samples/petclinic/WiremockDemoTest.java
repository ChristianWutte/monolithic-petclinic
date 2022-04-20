package org.springframework.samples.petclinic;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vets.controller.VetClient;
import org.springframework.samples.vets.dto.VetDto;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class WiremockDemoTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    private VetClient vetClient = new VetClient();

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void how_to_stub_a_server_with_wiremock() {
        wireMock.stubFor(get(urlEqualTo("/api/v1/vets"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                    .withBodyFile( "/api/vets_response.json" )));

        List<VetDto> vets = vetClient.retrieveVets();
        assertThat( vets ).isNotEmpty();
        assertThat(vets)
                .filteredOn(vet -> vet.getId() == 3)
                .hasSize(1)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Douglas")
                .hasFieldOrPropertyWithValue("nrOfSpecialties", 2)
                .extracting( VetDto::getSpecialties).asList()
                .extracting("name")
                .containsExactly("dentistry", "surgery");
    }
}