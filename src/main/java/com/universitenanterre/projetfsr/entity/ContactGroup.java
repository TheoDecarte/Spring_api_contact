package com.universitenanterre.projetfsr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Entity(name = "CONTACT_GROUP")
@NamedQueries({
        @NamedQuery(name="ContactGroup.findAll", query="SELECT cg FROM CONTACT_GROUP cg")
})
@Data
@NoArgsConstructor
public class ContactGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String groupName;
    private String groupDescription;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "contactGroups")
    @JsonIgnore
    private List<Contact> contacts;
}
