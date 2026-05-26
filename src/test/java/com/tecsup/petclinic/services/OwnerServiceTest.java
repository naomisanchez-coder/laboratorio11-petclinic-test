package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerService ownerService;

	@Test
	public void testCreateOwner() {

		Owner owner = new Owner();
		owner.setFirstName("Jose");
		owner.setLastName("Perez");

		Owner newOwner = ownerService.create(owner);

		log.info("OWNER CREATED: " + newOwner);

		assertNotNull(newOwner.getId());
		assertEquals("Jose", newOwner.getFirstName());
		assertEquals("Perez", newOwner.getLastName());
	}

	@Test
	public void testUpdateOwner() {

		Owner owner = new Owner();
		owner.setFirstName("Lucia");
		owner.setLastName("Garcia");

		Owner createdOwner = ownerService.create(owner);

		createdOwner.setFirstName("Lucia Maria");
		createdOwner.setLastName("Garcia Torres");

		Owner updatedOwner = ownerService.update(createdOwner);

		assertEquals("Lucia Maria", updatedOwner.getFirstName());
		assertEquals("Garcia Torres", updatedOwner.getLastName());
	}

	@Test
	public void testFindOwnerById() {

		Owner owner = new Owner();
		owner.setFirstName("Mario");
		owner.setLastName("Lopez");

		Owner createdOwner = ownerService.create(owner);

		try {

			Owner foundOwner = ownerService.findById(createdOwner.getId());

			assertEquals(createdOwner.getId(), foundOwner.getId());
			assertEquals("Mario", foundOwner.getFirstName());

		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindOwnerByFirstName() {

		Owner owner = new Owner();
		owner.setFirstName("Andrea");
		owner.setLastName("Ruiz");

		ownerService.create(owner);

		List<Owner> owners = ownerService.findByFirstName("Andrea");

		assertTrue(owners.size() > 0);
	}

	@Test
	public void testDeleteOwner() {

		Owner owner = new Owner();
		owner.setFirstName("Carlos");
		owner.setLastName("Mendoza");

		Owner createdOwner = ownerService.create(owner);

		try {
			ownerService.delete(createdOwner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}

		assertThrows(OwnerNotFoundException.class, () -> {
			ownerService.findById(createdOwner.getId());
		});
	}
}
