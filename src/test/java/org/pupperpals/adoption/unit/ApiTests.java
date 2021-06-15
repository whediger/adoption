package org.pupperpals.adoption.unit;


import org.junit.jupiter.api.Test;
import org.pupperpals.adoption.model.Pupper;
import org.pupperpals.adoption.service.PupperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class ApiTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    PupperService service;

    @Test
    void getAllPuppers() throws Exception {
        List<Pupper> puppers = new ArrayList<Pupper>();
        puppers.add(new Pupper("Spot", "Dalmation"));
        puppers.add(new Pupper("Goldie", "Cocker Spaniel"));

        when(service.findAllPuppers()).thenReturn(puppers);

        mvc.perform(get("/puppers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0]").value(puppers.get(0)))
                .andExpect(jsonPath("[1]").value(puppers.get(1)));
    }

}
