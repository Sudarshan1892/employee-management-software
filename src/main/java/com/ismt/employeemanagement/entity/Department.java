package com.ismt.employeemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String headOfDept;

    public Department() {

    }

    public Department(int id, String name, String headOfDept) {
        this.id = id;
        this.name = name;
        this.headOfDept = headOfDept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadOfDept() {
        return headOfDept;
    }

    public void setHeadOfDept(String headOfDept) {
        this.headOfDept = headOfDept;
    }
}
