package com.example.campus_connect.repositories;

import com.example.campus_connect.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
