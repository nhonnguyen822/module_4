package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(length = 2000)
    private String comment;

}
