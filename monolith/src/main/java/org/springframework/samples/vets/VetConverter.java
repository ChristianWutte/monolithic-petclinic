package org.springframework.samples.vets;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vets.dto.VetDto;
import org.springframework.samples.vets.model.Vet;
import org.springframework.stereotype.Component;

@Component
public class VetConverter
{
    @Autowired
    private SpecialtyConverter specialtyConverter;

    public VetDto convertFromDb( Vet vet )
    {
        VetDto vetDto = new VetDto();
        vetDto.setId( Objects.requireNonNull( vet.getId() ) );
        vetDto.setFirstName( vet.getFirstName() );
        vetDto.setLastName( vet.getLastName() );
        vetDto.setSpecialties( vet.getSpecialties().stream()
                .map( specialtyConverter::convertFromDb )
                .collect( Collectors.toList())
        );
        return vetDto;
    }
}
