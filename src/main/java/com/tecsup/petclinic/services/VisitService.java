package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import java.util.List;

public interface VisitService {
    Visit create(Visit visit);
    Visit update(Visit visit);
    Visit findById(Long id);
    List<Visit> findAll();
    List<Visit> findByPetId(Long petId);
    void delete(Long id);
}
