package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {
        Vet vet = new Vet();
        vet.setFirstName("Carlos");
        vet.setLastName("Ramirez");

        Vet newVet = vetService.create(vet);

        log.info("VET CREATED: " + newVet);

        assertNotNull(newVet.getId());
        assertEquals("Carlos", newVet.getFirstName());
        assertEquals("Ramirez", newVet.getLastName());
    }

    @Test
    public void testUpdateVet() {
        Vet vet = new Vet();
        vet.setFirstName("Ana");
        vet.setLastName("Lopez");

        Vet createdVet = vetService.create(vet);

        createdVet.setFirstName("Ana Maria");
        createdVet.setLastName("Lopez Torres");

        Vet updatedVet = vetService.update(createdVet);

        assertEquals("Ana Maria", updatedVet.getFirstName());
        assertEquals("Lopez Torres", updatedVet.getLastName());
    }

    @Test
    public void testFindVetById() {
        Vet vet = new Vet();
        vet.setFirstName("Luis");
        vet.setLastName("Gomez");

        Vet createdVet = vetService.create(vet);

        try {
            Vet foundVet = vetService.findById(createdVet.getId());

            assertEquals(createdVet.getId(), foundVet.getId());
            assertEquals("Luis", foundVet.getFirstName());
            assertEquals("Gomez", foundVet.getLastName());

        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFindVetByFirstName() {
        Vet vet = new Vet();
        vet.setFirstName("Maria");
        vet.setLastName("Fernandez");

        vetService.create(vet);

        List<Vet> vets = vetService.findByFirstName("Maria");

        assertTrue(vets.size() > 0);
    }

    @Test
    public void testDeleteVet() {
        Vet vet = new Vet();
        vet.setFirstName("Pedro");
        vet.setLastName("Castro");

        Vet createdVet = vetService.create(vet);

        try {
            vetService.delete(createdVet.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        assertThrows(VetNotFoundException.class, () -> {
            vetService.findById(createdVet.getId());
        });
    }
}
