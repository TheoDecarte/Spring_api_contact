package com.universitenanterre.projetfsr.controller;

import com.universitenanterre.projetfsr.entity.Contact;
import com.universitenanterre.projetfsr.entity.ContactGroup;
import com.universitenanterre.projetfsr.service.ContactService;
import com.universitenanterre.projetfsr.service.GroupService;
import com.universitenanterre.projetfsr.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class MainController {

    private final ContactService contactService;
    private final GroupService groupService;
    private final NumberService numberService;


    /* Contact */

    @PostMapping(value = "/saveContact")
    public void saveContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
    }

    @PostMapping(value = "/updateContact")
    public void updateContact(@RequestBody Contact contact) {
        contactService.updateContact(contact);
    }

    @GetMapping(value = "/contact")
    public Contact getContact(@RequestParam("id") int id) {
        return contactService.getContact(id);
    }


    @GetMapping(value = "/contacts")
    public List<Contact> getContacts() {
        List<Contact> contacts = contactService.getContacts();

        return contacts.stream().map(c -> Contact.builder()
                .id(c.getId())
                .email(c.getEmail())
                .firstname(c.getFirstname())
                .lastname(c.getLastname())
                .phoneNumbers(c.getPhoneNumbers())
                .build()).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/deleteContact")
    public void deleteContact(@RequestParam("id") int id) {
        contactService.deleteContact(id);
    }



    /* Contact Groups */

    @PostMapping(value = "/updateGroup")
    public void updateGroup(@RequestBody ContactGroup group) {
        groupService.updateGroup(group);
    }


    @GetMapping(value = "/getGroups")
    public List<ContactGroup> getGroups() {
        List<ContactGroup> groups = groupService.getGroups();
        return groups;
    }

    @DeleteMapping(value = "/deleteGroup")
    public void deleteGroup(@RequestParam("id") int id) {
        groupService.deleteGroup(id);
    }


    @DeleteMapping(value = "/deleteNumber")
    public void deleteNumber(@RequestParam("id") int id) {
        numberService.deleteNumber(id);
    }


}
