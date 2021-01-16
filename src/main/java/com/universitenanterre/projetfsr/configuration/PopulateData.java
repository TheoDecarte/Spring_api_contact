package com.universitenanterre.projetfsr.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.universitenanterre.projetfsr.entity.Contact;
import com.universitenanterre.projetfsr.entity.ContactGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@RestController
public class PopulateData {

    private final EntityManager em;

    @Transactional
    @GetMapping(value = "/populate")
    public void populate(){
        List<ContactGroup> groups = populateGroups();
        groups.stream().forEach(o -> em.persist(o));

        List<Contact> contacts = populateContacts();
        contacts.stream().forEach(o -> em.persist(o));
    }



    public List<ContactGroup> populateGroups(){
        ObjectMapper mapper = new ObjectMapper();

        List<ContactGroup> contactGroup = new ArrayList<>();

        try {
            contactGroup = mapper.readValue(new File("src/main/resources/populateJson/groups.json"),  new TypeReference<List<ContactGroup>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactGroup;
    }


    public List<Contact> populateContacts(){
        ObjectMapper mapper = new ObjectMapper();

        List<Contact> contacts = new ArrayList<>();

        try {
            contacts = mapper.readValue(new File("src/main/resources/populateJson/contacts.json"),  new TypeReference<List<Contact>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

}