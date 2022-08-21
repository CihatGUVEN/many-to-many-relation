package com.example.manytomanyrelation.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    @Embedded
    @NotNull
    @Column(unique = true)
    private Phone phone;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "parent_student",
            joinColumns = { @JoinColumn(name = "parent_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private Set<Student> students = new HashSet<>();

}
