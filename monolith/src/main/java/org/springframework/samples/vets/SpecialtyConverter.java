package org.springframework.samples.vets;

import org.springframework.samples.vets.dto.SpecialtyDto;
import org.springframework.samples.vets.model.Specialty;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyConverter
{
    public SpecialtyDto convertFromDb( Specialty specialty )
    {
        SpecialtyDto specialtyDto = new SpecialtyDto();
        specialtyDto.setName( specialty.getName() );
        return specialtyDto;
    }
}
