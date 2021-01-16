package com.universitenanterre.projetfsr.dao.group;

import com.universitenanterre.projetfsr.entity.ContactGroup;

import java.util.List;

public interface GroupDAO {

    void deleteById(int groupId);
    void update(ContactGroup group);
    List<ContactGroup> findAll();

}
