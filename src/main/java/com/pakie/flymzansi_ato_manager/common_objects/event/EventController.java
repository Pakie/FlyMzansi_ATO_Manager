package com.pakie.flymzansi_ato_manager.common_objects.event;

import com.pakie.flymzansi_ato_manager.common_objects.event.Event;
import com.pakie.flymzansi_ato_manager.common_objects.event.EventService;
import com.pakie.flymzansi_ato_manager.common_objects.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    RoomService roomService;

    //List Events
    @GetMapping("/events")
    //public String events(){
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "event/events";
    }

    @GetMapping("/events/add-event")
    public String addEvent(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("rooms", roomService.getAllRooms());

        return "event/add_event";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event){
        eventService.saveEvent(event);
        return "redirect:/events";
    }
    @GetMapping("/events/update-event/{id}")
    public String updateEvent(@PathVariable(value = "id") Long id, Model model){
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("rooms", roomService.getAllRooms());

        return "event/update_event";
    }
    @GetMapping("/events/delete-event/{id}")
    public String deleteEvent(@PathVariable(value = "id") Long id, Model model){
        this.eventService.deleteEventById(id);
        return "redirect:/events";
    }
}
