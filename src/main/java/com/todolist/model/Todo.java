package com.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "todos", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Todo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "aciklama")
    private String aciklama;
}
