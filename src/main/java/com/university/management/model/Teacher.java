package com.university.management.model;

public class Teacher {
    private Long id;
    private String name;
    private String department;
    private String email;
    private String designation;

    public Teacher() {}

    public Teacher(Long id, String name, String department, String email, String designation) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
