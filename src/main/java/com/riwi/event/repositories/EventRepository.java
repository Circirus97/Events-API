package com.riwi.event.repositories;


import com.riwi.event.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

    Event findByName(String name);

}
