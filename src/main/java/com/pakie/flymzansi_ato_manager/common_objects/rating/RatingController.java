package com.pakie.flymzansi_ato_manager.common_objects.rating;

import com.pakie.flymzansi_ato_manager.common_objects.rating.Rating;
import com.pakie.flymzansi_ato_manager.common_objects.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RatingController {
    @Autowired
    RatingService ratingService;

    //List Ratings
    @GetMapping("/ratings")
    //public String ratings(){
    public String getAllRatings(Model model) {
        model.addAttribute("ratings", ratingService.getAllRatings());
        return "rating/ratings";
    }

    @GetMapping("/ratings/add-rating")
    public String addRating(Model model){
        Rating rating = new Rating();
        model.addAttribute("rating", rating);
        return "rating/add_rating";
    }

    @PostMapping("/saveRating")
    public String saveRating(@ModelAttribute("rating") Rating rating){
        ratingService.saveRating(rating);
        return "redirect:/ratings";
    }
    @GetMapping("/ratings/update-rating/{id}")
    public String updateRating(@PathVariable(value = "id") Long id, Model model){
        Rating rating = ratingService.getRatingById(id);
        model.addAttribute("rating", rating);

        return "rating/update_rating";
    }
    @GetMapping("/ratings/delete-rating/{id}")
    public String deleteRating(@PathVariable(value = "id") Long id, Model model){
        this.ratingService.deleteRatingById(id);
        return "redirect:/ratings";
    }
}
