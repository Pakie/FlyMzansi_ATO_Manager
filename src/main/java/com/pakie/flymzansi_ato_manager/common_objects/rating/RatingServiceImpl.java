package com.pakie.flymzansi_ato_manager.common_objects.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public void saveRating(Rating rating) {
        this.ratingRepo.save(rating);
    }

    @Override
    public Rating getRatingById(Long id) {
        Optional<Rating> optional = ratingRepo.findById(id);
        Rating rating = null;
        if (optional.isPresent()){
            rating = optional.get();
        } else {
            throw new RuntimeException("The rating with ID " + id + " does not exist");
        }
        return rating;
    }

    @Override
    public void deleteRatingById(Long id) {
        this.ratingRepo.deleteById(id);
    }
}
