package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogs")

public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 1000)
    private String summary;
    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id")
    private List<Comments> comments = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users users;
}
