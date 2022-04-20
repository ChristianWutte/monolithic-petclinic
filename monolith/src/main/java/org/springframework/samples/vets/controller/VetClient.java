package org.springframework.samples.vets.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vets.dto.VetDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VetClient
{

//    @Autowired
//    private RestTemplate restTemplate;

    public List<VetDto> retrieveVets()
    {
        return Arrays.asList( new RestTemplate().getForObject( "http://localhost:8089/api/v1/vets", VetDto[].class ) );
    }
}
