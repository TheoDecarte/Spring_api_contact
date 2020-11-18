package com.universitenanterre.projetfsr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ContactDTO implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
}
