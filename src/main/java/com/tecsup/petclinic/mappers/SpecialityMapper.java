package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;

public class SpecialityMapper {

    public static Speciality toEntity(SpecialityDTO dto) {

        Speciality entity = new Speciality();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    public static SpecialityDTO toDTO(Speciality entity) {

        SpecialityDTO dto = new SpecialityDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
}