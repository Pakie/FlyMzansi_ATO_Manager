package com.pakie.flymzansi_ato_manager.common_objects.room.room_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomCategoryController {
    @Autowired
    RoomCategoryService roomCategoryService;

    //List RoomCategories
    @GetMapping("/rooms/room-categories")
    //public String roomCategories(){
    public String getAllRoomCategories(Model model) {
        model.addAttribute("roomCategories", roomCategoryService.getAllRoomCategories());
        return "room/room_category/room_categories";
    }

    @GetMapping("/rooms/room-categories/add-room-category")
    public String addRoomCategory(Model model){
        RoomCategory roomCategory = new RoomCategory();
        model.addAttribute("roomCategory", roomCategory);
        return "room/room_category/add_room_category";
    }

    @PostMapping("/saveRoomCategory")
    public String saveRoomCategory(@ModelAttribute("roomCategory") RoomCategory roomCategory){
        roomCategoryService.saveRoomCategory(roomCategory);
        return "redirect:/rooms/room-categories";
    }
    @GetMapping("/rooms/room-categories/update-room-category/{id}")
    public String updateRoomCategory(@PathVariable(value = "id") Long id, Model model){
        RoomCategory roomCategory = roomCategoryService.getRoomCategoryById(id);
        model.addAttribute("roomCategory", roomCategory);

        return "room/room_category/update_room_category";
    }
    @GetMapping("/rooms/room-categories/delete-room-category/{id}")
    public String deleteRoomCategory(@PathVariable(value = "id") Long id, Model model){
        this.roomCategoryService.deleteRoomCategoryById(id);
        return "redirect:/rooms/room-categories";
    }
}
