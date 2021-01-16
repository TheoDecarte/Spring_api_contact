package com.universitenanterre.projetfsr.dao.contact;

import com.universitenanterre.projetfsr.entity.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContactDAOProxy implements ContactDAO{

    private final EntityManager em;

    @Override
    public List<Contact> findAll(){
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contacts;
    }


    @Transactional
    @Override
    public void update(Contact contact){
        em.merge(contact);
    }


    @Transactional
    @Override
    public void save(Contact contact){
        em.persist(contact);
    }

    @Override
    public Contact findById(int contactId){
        Contact contact = em.find(Contact.class, contactId);
        return contact;
    }

    @Transactional
    @Override
    public void deleteById(int contactId){
        Contact contact = em.find(Contact.class,contactId);
        em.remove(contact);
    }
}