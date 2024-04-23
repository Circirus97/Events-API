package com.riwi.event.services;

import com.riwi.event.entities.Event;
import com.riwi.event.repositories.EventRepository;
import com.riwi.event.services.service_abstract.IEventService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    private final EventRepository eventRepository;
    @Override
    @SneakyThrows //Extiende de Throws ayuda para las excepciones
    public Event save(Event event) {

        if (event.getDate().isBefore(LocalDate.now())) {
            throw new Exception("La fecha del evento es inferior a la fecha actual"); //El Exception devuelve una excepcion con un mensaje controlado
        }if (event.getCapacity() < 1){
            throw new Exception("La capacidad del evento es menor a 1"); //El Exception devuelve una excepcion con un mensaje controlado
        }

        return this.eventRepository.save(event);

    }

    @Override
    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event findById(String id) {
        return this.eventRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public Event update(String id, Event event) {
        this.eventRepository.findById(id).orElseThrow();
        event.setId(id);

        return this.eventRepository.save(event);
    }

    @Override
    public Event findByName(String name) {
        return this.eventRepository.findByName(name);
    }

    @Override
    public Page<Event> getAll(Pageable pageable) {
        return this.eventRepository.findAll(pageable);
    }


}
