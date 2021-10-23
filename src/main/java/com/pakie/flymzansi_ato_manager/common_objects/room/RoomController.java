package com.pakie.flymzansi_ato_manager.common_objects.room;

import com.pakie.flymzansi_ato_manager.common_objects.room.room_category.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    RoomCategoryService roomCategoryService;

    //List Rooms
    @GetMapping("/rooms")
    //public String rooms(){
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "room/rooms";
    }

    @GetMapping("/rooms/add-room")
    public String addRoom(Model model){
        Room room = new Room();
        model.addAttribute("room", room);
        model.addAttribute("roomCategories", roomCategoryService.getAllRoomCategories());
        return "room/add_room";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@ModelAttribute("room") Room room){
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }
    @GetMapping("/rooms/update-room/{id}")
    public String updateRoom(@PathVariable(value = "id") Long id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        model.addAttribute("roomCategories", roomCategoryService.getAllRoomCategories());

        return "room/update_room";
    }
    @GetMapping("/rooms/delete-room/{id}")
    public String deleteRoom(@PathVariable(value = "id") Long id, Model model){
        this.roomService.deleteRoomById(id);
        return "redirect:/rooms";
    }
}
