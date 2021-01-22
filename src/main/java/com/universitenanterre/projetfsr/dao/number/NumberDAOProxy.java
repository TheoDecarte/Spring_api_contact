package com.universitenanterre.projetfsr.dao.number;

import com.universitenanterre.projetfsr.entity.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
public class NumberDAOProxy implements NumberDAO {

    @Autowired
    private EntityManager em;

    @Transactional
    @Override
    public void deleteById(int numberId){
        PhoneNumber phoneNumber = em.find(PhoneNumber.class,numberId);
        em.remove(phoneNumber);
    }

}
