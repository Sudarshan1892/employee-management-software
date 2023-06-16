package com.ismt.employeemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "designation")
public class Designation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String title;
    private int department;

    public Designation() {
    }

    public Designation(int id, String title, int department) {
        this.id = id;
        this.title = title;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
