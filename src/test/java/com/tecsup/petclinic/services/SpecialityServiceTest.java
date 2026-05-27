package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.exceptions.SpecialityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SpecialityServiceTest {

    @Autowired
    private SpecialityService specialityService;

    @Test
    public void testFindSpecialityById() {

        final String NAME_EXPECTED = "radiology";
        Integer ID = 1;

        SpecialityDTO speciality = null;

        try {
            speciality = this.specialityService.findById(ID);
        } catch (SpecialityNotFoundException e) {
            fail(e.getMessage());
        }

        assertEquals(NAME_EXPECTED, speciality.getName());
    }

    @Test
    public void testFindSpecialityByName() {

        String FIND_NAME = "radiology";
        int SIZE_EXPECTED = 1;

        List<SpecialityDTO> specialities = this.specialityService.findByName(FIND_NAME);

        assertEquals(SIZE_EXPECTED, specialities.size());
    }

    @Test
    public void testCreateSpeciality() {

        String SPECIALITY_NAME = "dermatology";

        SpecialityDTO specialityDTO = SpecialityDTO.builder()
                .name(SPECIALITY_NAME)
                .build();

        SpecialityDTO newSpecialityDTO = this.specialityService.create(specialityDTO);

        log.info("SPECIALITY CREATED: {}", newSpecialityDTO);

        assertNotNull(newSpecialityDTO.getId());
        assertEquals(SPECIALITY_NAME, newSpecialityDTO.getName());
    }

    @Test
    public void testUpdateSpeciality() {

        String SPECIALITY_NAME = "oncology";
        String UP_SPECIALITY_NAME = "oncology updated";

        SpecialityDTO specialityDTO = SpecialityDTO.builder()
                .name(SPECIALITY_NAME)
                .build();

        SpecialityDTO specialityDTOCreated = this.specialityService.create(specialityDTO);

        specialityDTOCreated.setName(UP_SPECIALITY_NAME);

        SpecialityDTO updatedSpecialityDTO = this.specialityService.update(specialityDTOCreated);

        log.info("SPECIALITY UPDATED: {}", updatedSpecialityDTO);

        assertEquals(UP_SPECIALITY_NAME, updatedSpecialityDTO.getName());
    }

    @Test
    public void testDeleteSpeciality() {

        String SPECIALITY_NAME = "neurology";

        SpecialityDTO specialityDTO = SpecialityDTO.builder()
                .name(SPECIALITY_NAME)
                .build();

        SpecialityDTO newSpecialityDTO = this.specialityService.create(specialityDTO);

        try {
            this.specialityService.delete(newSpecialityDTO.getId());
        } catch (SpecialityNotFoundException e) {
            fail(e.getMessage());
        }

        try {
            this.specialityService.findById(newSpecialityDTO.getId());
            assertTrue(false);
        } catch (SpecialityNotFoundException e) {
            assertTrue(true);
        }
    }
}