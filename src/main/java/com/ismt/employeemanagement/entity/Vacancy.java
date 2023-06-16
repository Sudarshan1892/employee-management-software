package com.ismt.employeemanagement.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vacancy")
public class Vacancy{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int designationId;
    private int candidatesRequired;
    private String requirements;
    private String qualification;
    private Date deadline;

    public Vacancy() {
    }

    public Vacancy(int id, int designationId, int candidatesRequired, String requirements, String qualification, Date deadline) {
        this.id = id;
        this.designationId = designationId;
        this.candidatesRequired = candidatesRequired;
        this.requirements = requirements;
        this.qualification = qualification;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDesignationId() {
        return designationId;
    }

    public void setDesignationId(int designationId) {
        this.designationId = designationId;
    }

    public int getCandidatesRequired() {
        return candidatesRequired;
    }

    public void setCandidatesRequired(int candidatesRequired) {
        this.candidatesRequired = candidatesRequired;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualifications) {
        this.qualification = qualifications;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
