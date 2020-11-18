package com.universitenanterre.projetfsr.proxy;

import com.universitenanterre.projetfsr.entity.Contact;
import com.universitenanterre.projetfsr.entity.ContactGroup;
import com.universitenanterre.projetfsr.entity.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactProxy {

    @Autowired
    private EntityManagerFactory emf;


    public List<ContactGroup> getGroups(){
        EntityManager em = emf.createEntityManager();
        List<ContactGroup> contacts = em.createQuery("SELECT cg FROM CONTACT_GROUP cg", ContactGroup.class).getResultList();
        em.close();

        return contacts;
    }

    public List<Contact> getContacts(){
        EntityManager em = emf.createEntityManager();
        List<Contact> contacts = em.createQuery("SELECT a FROM CONTACT a", Contact.class).getResultList();
        em.close();

        return contacts;
    }


    public void updateContact(Contact contact){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(contact);

        em.getTransaction().commit();
        em.close();
    }

    public void updateGroup(ContactGroup group){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(group);

        em.getTransaction().commit();
        em.close();
    }


    public void saveContact(Contact contact){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(contact);

        em.getTransaction().commit();
        em.close();
    }

    public Contact getContact(int contactId){
        EntityManager em = emf.createEntityManager();
        //TypedQuery<Contact> singleResult = em.createQuery("SELECT c FROM CONTACT c where c.id = :contactId", Contact.class);
        Contact contact = em.find(Contact.class, contactId);
        //Contact contact = singleResult.setParameter("contactId", contactId).getSingleResult();
        em.close();

        return contact;
    }


    public void deleteContact(int contactId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Contact contact = em.find(Contact.class,contactId);
        em.remove(contact);
        //TypedQuery<Contact> query = em.createQuery("DELETE FROM CONTACT c where c.id = :contactId", Contact.class);
        //query.setParameter("contactId", contactId).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public void deleteGroup(int groupId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ContactGroup group = em.find(ContactGroup.class,groupId);
        em.remove(group);

        em.getTransaction().commit();
        em.close();
    }

    public void deleteNumber(int numberId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PhoneNumber phoneNumber = em.find(PhoneNumber.class,numberId);
        em.remove(phoneNumber);

        em.getTransaction().commit();
        em.close();
    }

}