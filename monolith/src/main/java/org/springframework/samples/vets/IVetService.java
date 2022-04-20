package org.springframework.samples.vets;

import java.util.Collection;

import org.springframework.samples.vets.dto.VetDto;

public interface IVetService
{
    Collection<VetDto> retrieveAllVets();
}
