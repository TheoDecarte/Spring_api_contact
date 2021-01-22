package com.universitenanterre.projetfsr.dao.group;

import com.universitenanterre.projetfsr.entity.ContactGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupDAOProxy implements GroupDAO{

    @Autowired
    private EntityManager em;


    @Transactional
    @Override
    public void deleteById(int groupId){
        ContactGroup group = em.find(ContactGroup.class,groupId);
        em.remove(group);
    }


    @Transactional
    @Override
    public void update(ContactGroup group){
        em.merge(group);
    }


    @Override
    public List<ContactGroup> findAll(){
        List<ContactGroup> contacts = em.createNamedQuery("ContactGroup.findAll", ContactGroup.class).getResultList();
        return contacts;
    }
}
