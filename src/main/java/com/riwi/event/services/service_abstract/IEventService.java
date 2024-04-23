package com.riwi.event.services.service_abstract;

import com.riwi.event.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEventService {

    Event save(Event event);

    List<Event> getAll();

    Event findById(String id);

    void delete(String id);

    Event update(String id, Event event);

    Event findByName(String name);

    Page<Event> getAll(Pageable pageable);

}
