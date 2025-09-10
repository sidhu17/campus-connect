package com.example.campus_connect.controllers;

import com.example.campus_connect.entities.Event;
import com.example.campus_connect.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    @GetMapping("/")
    public String home() {
        return "Campus Connect Backend is Running!";
    }

    @GetMapping("/api/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/api/events/{id}")
    public Event getEventById(@PathVariable int id) {
        return eventRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/events")
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/api/events/{id}")
    public Event updateEvent(@PathVariable int id, @RequestBody Event updatedEvent) {
        Event existing = eventRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(updatedEvent.getTitle());
            existing.setDescription(updatedEvent.getDescription());
            existing.setDateTime(updatedEvent.getDateTime());
            existing.setLocation(updatedEvent.getLocation());
            existing.setPosterUrl(updatedEvent.getPosterUrl());
            existing.setSpeakerList(updatedEvent.getSpeakerList());
            existing.setMaxParticipants(updatedEvent.getMaxParticipants());
            return eventRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/api/events/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventRepository.deleteById(id);
    }
}
