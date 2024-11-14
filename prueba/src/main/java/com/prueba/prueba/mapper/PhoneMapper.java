package com.prueba.prueba.mapper;

import org.mapstruct.Mapper;

import com.prueba.prueba.dto.PhoneDTO;
import com.prueba.prueba.entity.PhoneEntity;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    PhoneEntity toEntity(PhoneDTO phoneDTO);
    PhoneDTO toDTO(PhoneEntity phone);
}
