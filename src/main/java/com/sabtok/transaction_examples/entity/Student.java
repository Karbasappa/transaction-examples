package com.sabtok.transaction_examples.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="STUDENTS")
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

}
