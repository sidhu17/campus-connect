package com.example.campus_connect.controllers;

import com.example.campus_connect.entities.Event;
import com.example.campus_connect.entities.Student;
import com.example.campus_connect.repositories.EventRepository;
import com.example.campus_connect.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    // ---------- Signup ----------
    @PostMapping("/signup")
    public Student signup(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // ---------- Login ----------
    @PostMapping("/login")
    public Student login(@RequestBody Student loginRequest) {
        Student student = studentRepository.findByEmail(loginRequest.getEmail());
        if (student != null && student.getPassword().equals(loginRequest.getPassword())) {
            return student; // ✅ success
        }
        return null; // ❌ invalid
    }

    // ---------- See All Events ----------
    @GetMapping("/{id}/events")
    public List<Event> getAllEvents(@PathVariable int id) {
        return eventRepository.findAll();
    }

    // ---------- Register for Event ----------
    @PostMapping("/{studentId}/register/{eventId}")
    public Student registerForEvent(@PathVariable int studentId, @PathVariable int eventId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (student != null && event != null) {
            student.getRegisteredEvents().add(event);
            return studentRepository.save(student);
        }
        return null;
    }

    // ---------- See My Registered Events ----------
    @GetMapping("/{studentId}/my-events")
    public Set<Event> getRegisteredEvents(@PathVariable int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getRegisteredEvents();
        }
        return null;
    }
}
