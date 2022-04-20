package org.springframework.samples.vets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vets.dto.VetDto;
import org.springframework.samples.vets.db.VetRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class VetService {

    @Autowired
    private VetRepository vets;

    @Autowired
    private VetConverter vetConverter;

    public Collection<VetDto> allVets() {
        return this.vets.findAll().stream()
                .map( vetConverter::convertFromDb )
                .collect( Collectors.toList() );
    }

}
