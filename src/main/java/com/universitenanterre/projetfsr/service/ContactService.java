package com.universitenanterre.projetfsr.service;

import com.universitenanterre.projetfsr.dao.contact.ContactDAO;
import com.universitenanterre.projetfsr.entity.Contact;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ContactService {

    private final ContactDAO contactDAO;

    public void saveContact(Contact contact) {
        contactDAO.save(contact);
    }

    public void updateContact(Contact contact) {
        contactDAO.update(contact);
    }

    public Contact getContact(int contactId){
        return contactDAO.findById(contactId);
    }

    public List<Contact> getContacts(){
        return contactDAO.findAll();
    }

    public void deleteContact(int contactId){
        contactDAO.deleteById(contactId);
    }
}
