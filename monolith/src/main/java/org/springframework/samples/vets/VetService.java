package org.springframework.samples.vets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vets.model.Vet;
import org.springframework.samples.vets.db.VetRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VetService {

    @Autowired
    private VetRepository vets;

    public Collection<Vet> allVets() {
        return this.vets.findAll();
    }

}
