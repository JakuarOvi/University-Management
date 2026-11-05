package com.university.management.model;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String program;
    private int year;
    private String status;

    public Student() {}

    public Student(Long id, String name, String email, String program, int year, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.program = program;
        this.year = year;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
