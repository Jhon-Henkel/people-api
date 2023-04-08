package com.people.api.peopleapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @OneToMany(fetch = FetchType.LAZY, cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Address> address;
}