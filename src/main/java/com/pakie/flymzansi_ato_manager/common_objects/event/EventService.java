package com.pakie.flymzansi_ato_manager.common_objects.event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    void saveEvent(Event event);
    Event getEventById(Long Id);
    void deleteEventById(Long Id);
}
