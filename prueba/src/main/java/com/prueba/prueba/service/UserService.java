package com.prueba.prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.dto.UserDTO;
import com.prueba.prueba.dto.UserResponseDTO;
import com.prueba.prueba.entity.UserEntity;
import com.prueba.prueba.exception.EmailException;
import com.prueba.prueba.mapper.UserMapper;
import com.prueba.prueba.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO registerUser(UserDTO userIn) throws Exception {
        // Validar si el correo ya existe
        Optional<UserEntity> existingUser = userRepository.findByEmail(userIn.getEmail());
        if (existingUser.isPresent()) {
            throw new EmailException("El correo ya registrado");
        }

        
        UserEntity user=new UserEntity();
        user=userMapper.toEntity(userIn);
  
        // Guardar el usuario
        return userMapper.toDTO(userRepository.save(user));
    }
}
