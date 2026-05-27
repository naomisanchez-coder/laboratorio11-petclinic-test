package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import com.tecsup.petclinic.dtos.PetDTO;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.mappers.PetMapper;
import com.tecsup.petclinic.repositories.PetRepository;
import com.tecsup.petclinic.util.TObjectCreator;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@Slf4j
@SpringBootTest
public class PetServiceMockitoTest {

    @Autowired
    private PetService petService;

    @Autowired
    private PetMapper petMapper;

    @MockitoBean
    private PetRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testFindPetById() {

        Pet petExpected = new Pet(1, "Leo", 1, 1, null);

        Mockito.when(this.repository.findById(1))
                .thenReturn(Optional.of(petExpected));

        PetDTO pet = null;

        try {
            pet = this.petService.findById(1);
        } catch (PetNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("Pet expected: {}", petExpected);
        log.info("Pet found: {}", pet);

        assertEquals(petExpected.getName(), pet.getName());
    }

    @Test
    public void testFindPetByName() {

        String FIND_NAME = "Leo";

        List<Pet> petsExpected = TObjectCreator.getPetsForFindByName();

        Mockito.when(this.repository.findByName(FIND_NAME))
                .thenReturn(petsExpected);

        List<PetDTO> pets = this.petService.findByName(FIND_NAME);

        assertEquals(petsExpected.size(), pets.size());
    }

    @Test
    public void testFindPetByTypeId() {

        int TYPE_ID = 5;

        List<Pet> petsExpected = TObjectCreator.getPetsForFindByTypeId();

        Mockito.when(this.repository.findByTypeId(TYPE_ID))
                .thenReturn(petsExpected);

        List<Pet> pets = this.petService.findByTypeId(TYPE_ID);

        assertEquals(petsExpected.size(), pets.size());
    }

    @Test
    public void testFindPetByOwnerId() {

        int OWNER_ID = 10;

        List<Pet> petsExpected = TObjectCreator.getPetsForFindByOwnerId();

        Mockito.when(this.repository.findByOwnerId(OWNER_ID))
                .thenReturn(petsExpected);

        List<Pet> pets = this.petService.findByOwnerId(OWNER_ID);

        assertEquals(petsExpected.size(), pets.size());
    }

    @Test
    public void testCreatePet() {

        Pet newPet = TObjectCreator.newPet();
        Pet newPetCreated = TObjectCreator.newPetCreated();

        PetDTO newPetDTO = this.petMapper.mapToDto(newPet);
        PetDTO hopePetDTOCreated = this.petMapper.mapToDto(newPetCreated);

        Mockito.when(this.repository.save(newPet))
                .thenReturn(newPetCreated);

        PetDTO newPetDTOCreated = this.petService.create(newPetDTO);

        log.info("Pet created: {}", newPetDTOCreated);

        assertNotNull(newPetDTOCreated.getId());
        assertEquals(hopePetDTOCreated.getName(), newPetDTOCreated.getName());
        assertEquals(hopePetDTOCreated.getOwnerId(), newPetDTOCreated.getOwnerId());
        assertEquals(hopePetDTOCreated.getTypeId(), newPetDTOCreated.getTypeId());
    }

    @Test
    public void testUpdatePet() {

        String UP_PET_NAME = "Bear2";
        int UP_OWNER_ID = 2;
        int UP_TYPE_ID = 2;

        Pet newPet = TObjectCreator.newPetForUpdate();
        Pet newPetCreate = TObjectCreator.newPetCreatedForUpdate();

        PetDTO newPetDTO = petMapper.mapToDto(newPet);

        Mockito.when(this.repository.save(newPet))
                .thenReturn(newPetCreate);

        PetDTO newPetDTOCreate = this.petService.create(newPetDTO);

        log.info("Pet created for update: {}", newPetDTOCreate);

        newPetDTOCreate.setName(UP_PET_NAME);
        newPetDTOCreate.setOwnerId(UP_OWNER_ID);
        newPetDTOCreate.setTypeId(UP_TYPE_ID);

        Pet newPetUpdate = this.petMapper.mapToEntity(newPetDTOCreate);

        Mockito.when(this.repository.save(newPetUpdate))
                .thenReturn(newPetUpdate);

        PetDTO petDTOUpdate = this.petService.update(newPetDTOCreate);

        log.info("Pet updated: {}", petDTOUpdate);

        assertEquals(UP_PET_NAME, petDTOUpdate.getName());
        assertEquals(UP_OWNER_ID, petDTOUpdate.getOwnerId());
        assertEquals(UP_TYPE_ID, petDTOUpdate.getTypeId());
    }

    @Test
    public void testDeletePet() {

        Pet newPet = TObjectCreator.newPetForDelete();
        Pet newPetCreate = TObjectCreator.newPetCreatedForDelete();

        PetDTO newPetDTO = this.petMapper.mapToDto(newPet);

        Mockito.when(this.repository.save(newPet))
                .thenReturn(newPetCreate);

        PetDTO petDTOCreate = this.petService.create(newPetDTO);

        log.info("Pet created for delete: {}", petDTOCreate);

        Mockito.when(this.repository.findById(newPetCreate.getId()))
                .thenReturn(Optional.of(newPetCreate));

        Mockito.doNothing().when(this.repository).delete(newPetCreate);

        try {
            this.petService.delete(petDTOCreate.getId());
        } catch (PetNotFoundException e) {
            fail(e.getMessage());
        }

        Mockito.when(this.repository.findById(newPetCreate.getId()))
                .thenReturn(Optional.empty());

        try {
            this.petService.findById(petDTOCreate.getId());
            assertTrue(false);
        } catch (PetNotFoundException e) {
            assertTrue(true);
        }
    }
}