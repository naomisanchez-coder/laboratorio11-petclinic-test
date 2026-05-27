package com.tecsup.petclinic.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exceptions.SpecialityNotFoundException;
import com.tecsup.petclinic.mappers.SpecialityMapper;
import com.tecsup.petclinic.repositories.SpecialityRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SpecialityServiceImpl implements SpecialityService {

	@Autowired
	private SpecialityRepository specialityRepository;

	@Override
	public SpecialityDTO findById(Integer id) throws SpecialityNotFoundException {

		Speciality speciality = specialityRepository.findById(id)
				.orElseThrow(() ->
						new SpecialityNotFoundException("Speciality not found"));

		return SpecialityMapper.toDTO(speciality);
	}

	@Override
	public List<SpecialityDTO> findByName(String name) {

		List<Speciality> specialities = specialityRepository.findByName(name);

		return specialities.stream()
				.map(SpecialityMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public SpecialityDTO create(SpecialityDTO specialityDTO) {

		Speciality speciality = SpecialityMapper.toEntity(specialityDTO);

		Speciality newSpeciality = specialityRepository.save(speciality);

		log.info("SPECIALITY CREATED: {}", newSpeciality);

		return SpecialityMapper.toDTO(newSpeciality);
	}

	@Override
	public SpecialityDTO update(SpecialityDTO specialityDTO) {

		Speciality speciality = SpecialityMapper.toEntity(specialityDTO);

		Speciality updatedSpeciality = specialityRepository.save(speciality);

		log.info("SPECIALITY UPDATED: {}", updatedSpeciality);

		return SpecialityMapper.toDTO(updatedSpeciality);
	}

	@Override
	public void delete(Integer id) throws SpecialityNotFoundException {

		Speciality speciality = specialityRepository.findById(id)
				.orElseThrow(() ->
						new SpecialityNotFoundException("Speciality not found"));

		specialityRepository.delete(speciality);

		log.info("SPECIALITY DELETED: {}", speciality);
	}
}