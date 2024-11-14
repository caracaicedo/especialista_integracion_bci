package com.prueba.prueba.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prueba.prueba.dto.UserDTO;
import com.prueba.prueba.dto.UserResponseDTO;
import com.prueba.prueba.entity.UserEntity;

@Mapper(componentModel = "spring", uses = {PhoneMapper.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modified", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "lastLogin", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "token", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "isActive", constant = "true")
    UserEntity toEntity(UserDTO dto);

    UserResponseDTO toDTO(UserEntity entity);
}