package com.example.campus_connect.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Lob
    private String description;

    private LocalDateTime dateTime;

    private String location;

    private String posterUrl;

    private String speakerList;

    private Integer maxParticipants;

    // ---------- Constructors ----------
    public Event() {}

    public Event(String title, String description, LocalDateTime dateTime, String location, String posterUrl, String speakerList, Integer maxParticipants) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.location = location;
        this.posterUrl = posterUrl;
        this.speakerList = speakerList;
        this.maxParticipants = maxParticipants;
    }

    // ---------- Getters and Setters ----------

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(String speakerList) {
        this.speakerList = speakerList;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
