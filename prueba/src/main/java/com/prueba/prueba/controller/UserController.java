package com.prueba.prueba.controller;


import com.prueba.prueba.dto.UserDTO;
import com.prueba.prueba.dto.UserResponseDTO;
import com.prueba.prueba.exception.EmailException;
import com.prueba.prueba.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO user) {
        try {
        	UserResponseDTO newUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (EmailException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("mensaje", e.getMessage())
            );
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of("mensaje", e.getMessage())
                );
            }
    }
}
