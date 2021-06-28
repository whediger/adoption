package org.pupperpals.adoption.service;

import org.pupperpals.adoption.model.Pupper;
import org.pupperpals.adoption.repository.PupperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PupperService {

    @Autowired
    PupperRepository repo;

    public List<Pupper> findAllPuppers() {
        return repo.findAll();
    }

    public void addPupper(Pupper p) {
        repo.save(p);
    }

    public Optional<Pupper> updatePupper(Pupper p, long id) {
        if(p.getName() == null && p.getBreed() == null) {}
        else if(p.getName() != null && p.getBreed() == null)
            repo.updatePupperName(p.getName(), id);
        else if(p.getName() == null && p.getBreed() != null)
            repo.updatePupperBreed(p.getBreed(), id);
        else {
            repo.updatePupperNameBreed(p.getBreed(), p.getName(), id);
        }


        return repo.findById(id);
    }
}
