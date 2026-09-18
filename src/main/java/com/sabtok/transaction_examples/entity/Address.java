package com.sabtok.transaction_examples.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

    @Id
    private Long Id;
    private String city;
}
