package com.pakie.flymzansi_ato_manager.common_objects.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepo eventRepo;

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public void saveEvent(Event event) {
        this.eventRepo.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        Optional<Event> optional = eventRepo.findById(id);
        Event event = null;
        if (optional.isPresent()){
            event = optional.get();
        } else {
            throw new RuntimeException("The event with ID " + id + " does not exist");
        }
        return event;
    }

    @Override
    public void deleteEventById(Long id) {
        this.eventRepo.deleteById(id);
    }
}
