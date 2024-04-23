package com.riwi.event.controller;

import com.riwi.event.entities.Event;
import com.riwi.event.services.service_abstract.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final IEventService iEventService;

    @PostMapping
    public ResponseEntity<Event> insert(@RequestBody Event event){
        return ResponseEntity.ok(this.iEventService.save(event));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(this.iEventService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> findById(@PathVariable String id){
        return ResponseEntity.ok(this.iEventService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        this.iEventService.delete(id);

        return ResponseEntity.ok("Se eliminó correctamente");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(
            @PathVariable String id,
            @RequestBody Event event
    ){
        return ResponseEntity.ok(this.iEventService.update(id, event));
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Event> findByName(@PathVariable String name){
        return ResponseEntity.ok(this.iEventService.findByName(name));
    }

    @GetMapping(path = "/page/{page}")
    public ResponseEntity<Page<Event>> getAll(@PathVariable Integer page){
        return ResponseEntity.ok(this.iEventService.getAll(PageRequest.of(page, 4)));
    }


}
