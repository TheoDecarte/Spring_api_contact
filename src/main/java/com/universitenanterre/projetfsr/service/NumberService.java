package com.universitenanterre.projetfsr.service;

import com.universitenanterre.projetfsr.dao.number.NumberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberService {

    private final NumberDAO numberDAO;


    public void deleteNumber(int numberId){
        numberDAO.deleteById(numberId);
    }
}
