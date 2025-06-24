package com.example.bai_tap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")

public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;
    private String email;
    private String address;

}
