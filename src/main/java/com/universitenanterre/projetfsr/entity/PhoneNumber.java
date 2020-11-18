package com.universitenanterre.projetfsr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@Entity(name = "PHONE_NUMBER")
@Data
@NoArgsConstructor
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String phoneKind;
    private String phoneNumber;


}
