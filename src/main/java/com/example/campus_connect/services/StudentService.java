package com.example.campus_connect.services;

import com.example.campus_connect.entities.Event;
import com.example.campus_connect.entities.Student;
import com.example.campus_connect.repositories.EventRepository;
import com.example.campus_connect.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    // ---------- Signup ----------
    public Student signup(Student student) {
        return studentRepository.save(student);
    }

    // ---------- Login ----------
    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    // ---------- Get All Events ----------
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // ---------- Register Student for Event ----------
    public Student registerForEvent(int studentId, int eventId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (student != null && event != null) {
            student.getRegisteredEvents().add(event);
            return studentRepository.save(student);
        }
        return null;
    }

    // ---------- Get Registered Events ----------
    public Set<Event> getRegisteredEvents(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getRegisteredEvents();
        }
        return null;
    }
}
