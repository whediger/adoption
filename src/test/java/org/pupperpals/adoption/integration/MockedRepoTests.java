package org.pupperpals.adoption.integration;

import org.junit.jupiter.api.Test;
import org.pupperpals.adoption.model.Pupper;
import org.pupperpals.adoption.repository.PupperRepository;
import org.pupperpals.adoption.service.PupperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockedRepoTests {
    @Autowired
    private MockMvc mvc;


    @MockBean
    PupperRepository repo;

    @Test
    void getAllPuppers() throws Exception {
        List<Pupper> puppers = new ArrayList<Pupper>();
        puppers.add(new Pupper("Spot", "Dalmation"));
        puppers.add(new Pupper("Goldie", "Cocker Spaniel"));

        when(repo.findAll()).thenReturn(puppers);

        mvc.perform(get("/puppers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0]").value(puppers.get(0)))
                .andExpect(jsonPath("[1]").value(puppers.get(1)));
    }

}
