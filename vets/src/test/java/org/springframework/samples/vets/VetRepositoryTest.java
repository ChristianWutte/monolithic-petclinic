package org.springframework.samples.vets;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.vets.db.VetRepository;
import org.springframework.samples.vets.model.Vet;

@SpringBootTest
public class VetRepositoryTest
{

    @Autowired
    private VetRepository vetsRepository;

    @Test
    void testFindVets() {
        Collection<Vet> all = vetsRepository.findAll();
        assertThat(all).hasSize(6);
    }
}
