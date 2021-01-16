package com.universitenanterre.projetfsr.dao.contact;

import com.universitenanterre.projetfsr.entity.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> findAll();

    void update(Contact contact);

    void save(Contact contact);

    Contact findById(int contactId);

    void deleteById(int contactId);
}
