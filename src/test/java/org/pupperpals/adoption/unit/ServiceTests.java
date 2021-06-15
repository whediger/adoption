

package org.pupperpals.adoption.unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pupperpals.adoption.model.Pupper;
import org.pupperpals.adoption.repository.PupperRepository;
import org.pupperpals.adoption.service.PupperService;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    PupperRepository repo;

    @InjectMocks
    PupperService service;


    @Test
    void testFindAllPuppers() {
        List<Pupper> puppers = new ArrayList<Pupper>();
        puppers.add(new Pupper("Spot", "Dalmation"));
        puppers.add(new Pupper("Goldie", "Cocker Spaniel"));

        when(repo.findAll()).thenReturn(puppers);

        List<Pupper> actual = service.findAllPuppers();

        assertEquals(puppers, actual);
    }
}
