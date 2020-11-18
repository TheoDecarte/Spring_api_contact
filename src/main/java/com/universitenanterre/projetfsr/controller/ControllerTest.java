package com.universitenanterre.projetfsr.controller;

import com.universitenanterre.projetfsr.entity.Address;
import com.universitenanterre.projetfsr.entity.Contact;
import com.universitenanterre.projetfsr.entity.ContactGroup;
import com.universitenanterre.projetfsr.entity.PhoneNumber;
import com.universitenanterre.projetfsr.proxy.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ControllerTest {


    @Autowired
    ContactProxy contactProxy;


    @PostMapping(value = "/saveContact")
    public void saveContact(@RequestBody Contact contact) {
        contactProxy.saveContact(contact);
    }

    @PostMapping(value = "/updateContact")
    public void updateContact(@RequestBody Contact contact) {
        contactProxy.updateContact(contact);
    }

    @PostMapping(value = "/updateGroup")
    public void updateGroup(@RequestBody ContactGroup group) {
        contactProxy.updateGroup(group);
    }


    @DeleteMapping(value = "/deleteContact")
    public void deleteContact(@RequestParam("id") int id) {
        contactProxy.deleteContact(id);
    }

    @DeleteMapping(value = "/deleteGroup")
    public void deleteGroup(@RequestParam("id") int id) {
        contactProxy.deleteGroup(id);
    }

    @DeleteMapping(value = "/deleteNumber")
    public void deleteNumber(@RequestParam("id") int id) {
        contactProxy.deleteNumber(id);
    }

    @GetMapping(value = "/contacts")
    public List<Contact> getContacts() {
        List<Contact> contacts = contactProxy.getContacts();

        List<Contact> collect = contacts.stream().map(c -> Contact.builder()
                .id(c.getId())
                .email(c.getEmail())
                .firstname(c.getFirstname())
                .lastname(c.getLastname())
                .build()).collect(Collectors.toList());

        return collect;
    }

    @GetMapping(value = "/getGroups")
    public List<ContactGroup> getGroups() {
        List<ContactGroup> groups = contactProxy.getGroups();
        return groups;
    }


    @GetMapping(value = "/contact")
    public Contact getContact(@RequestParam("id") int id) {
        Contact c = contactProxy.getContact(id);

        return c;
    }

    @GetMapping(value = "/contact/{id}/address")
    public Address getAddress(@PathVariable int id) {
        return contactProxy.getContact(id).getAddress();
    }

    @GetMapping(value = "/contact/{id}/phoneNumbers")
    public Set<PhoneNumber> getPhoneNumbers(@PathVariable int id) {
        return contactProxy.getContact(id).getPhoneNumbers();
    }

    @GetMapping(value = "/contact/{id}/groups")
    public Set<ContactGroup> getContactGroups(@PathVariable int id) {
        return contactProxy.getContact(id).getContactGroups();
    }
}
