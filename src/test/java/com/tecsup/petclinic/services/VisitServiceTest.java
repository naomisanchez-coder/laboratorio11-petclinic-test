package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exceptions.VisitNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void testCreateVisit() {
        Visit visit = new Visit();
        visit.setPetId(1L);
        visit.setVisitDate(new Date());
        visit.setDescription("Consulta de rutina");
        Visit saved = visitService.create(visit);
        log.info("Visit creada: " + saved);
        assertNotNull(saved.getId());
        assertEquals("Consulta de rutina", saved.getDescription());
    }

    @Test
    public void testFindVisitById() {
        Visit visit = new Visit();
        visit.setPetId(1L);
        visit.setVisitDate(new Date());
        visit.setDescription("Revision anual");
        Visit saved = visitService.create(visit);
        Visit found = visitService.findById(saved.getId());
        log.info("Visit encontrada: " + found);
        assertNotNull(found);
        assertEquals(saved.getId(), found.getId());
    }

    @Test
    public void testUpdateVisit() {
        Visit visit = new Visit();
        visit.setPetId(2L);
        visit.setVisitDate(new Date());
        visit.setDescription("Vacunacion inicial");
        Visit saved = visitService.create(visit);
        saved.setDescription("Vacunacion completada");
        Visit updated = visitService.update(saved);
        log.info("Visit actualizada: " + updated);
        assertEquals("Vacunacion completada", updated.getDescription());
    }

    @Test
    public void testDeleteVisit() {
        Visit visit = new Visit();
        visit.setPetId(3L);
        visit.setVisitDate(new Date());
        visit.setDescription("Visita para eliminar");
        Visit saved = visitService.create(visit);
        Long id = saved.getId();
        visitService.delete(id);
        log.info("Visit eliminada con id: " + id);
        assertThrows(VisitNotFoundException.class, () -> visitService.findById(id));
    }

    @Test
    public void testFindVisitsByPetId() {
        Visit v1 = new Visit();
        v1.setPetId(10L);
        v1.setVisitDate(new Date());
        v1.setDescription("Primera visita del pet 10");
        visitService.create(v1);
        Visit v2 = new Visit();
        v2.setPetId(10L);
        v2.setVisitDate(new Date());
        v2.setDescription("Segunda visita del pet 10");
        visitService.create(v2);
        List<Visit> visits = visitService.findByPetId(10L);
        log.info("Visitas para petId=10: " + visits.size());
        assertTrue(visits.size() >= 2);
    }
}
