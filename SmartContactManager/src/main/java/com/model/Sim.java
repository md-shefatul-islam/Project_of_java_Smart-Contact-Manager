package com.model;

import javax.persistence.*;

@Entity
@Table(name = "sim")
public class Sim {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Sim() {
    }

    public Sim(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sim(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
