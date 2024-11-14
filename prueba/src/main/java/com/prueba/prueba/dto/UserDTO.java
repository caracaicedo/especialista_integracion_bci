package com.prueba.prueba.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private boolean isActive;

    private List<PhoneDTO> phones;
}
