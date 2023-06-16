package com.ismt.employeemanagement.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int amount;
    private int tax;
    private int bonus;
    private int employeeId;
    private Date date;

    public Salary() {
    }

    public Salary(int id, int amount, int tax, int bonus, int employeeId, Date date) {
        this.id = id;
        this.amount = amount;
        this.tax = tax;
        this.bonus = bonus;
        this.employeeId = employeeId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
