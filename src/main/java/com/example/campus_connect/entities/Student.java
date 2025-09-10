package com.example.campus_connect.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;   // for login
    private String department;
    private String year;

    // Relation: Student can register for many Events
    @ManyToMany
    @JoinTable(
            name = "student_event",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> registeredEvents = new HashSet<>();

    // ---------- Constructors ----------
    public Student() {}

    public Student(String name, String email, String password, String department, String year) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.year = year;
    }

    // ---------- Getters and Setters ----------
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public Set<Event> getRegisteredEvents() { return registeredEvents; }
    public void setRegisteredEvents(Set<Event> registeredEvents) { this.registeredEvents = registeredEvents; }
}
