package com.universitenanterre.projetfsr.service;

import com.universitenanterre.projetfsr.dao.group.GroupDAO;
import com.universitenanterre.projetfsr.entity.ContactGroup;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GroupService {

    private final GroupDAO groupDAO;

    public void deleteGroup(int id) {
        groupDAO.deleteById(id);
    }

    public void updateGroup(ContactGroup group) {
        groupDAO.update(group);
    }

    public List<ContactGroup> getGroups(){
        return groupDAO.findAll();
    }

}
