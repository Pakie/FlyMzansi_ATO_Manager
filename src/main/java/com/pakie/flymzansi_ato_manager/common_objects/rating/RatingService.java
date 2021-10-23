package com.pakie.flymzansi_ato_manager.common_objects.rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();
    void saveRating(Rating rating);
    Rating getRatingById(Long Id);
    void deleteRatingById(Long Id);
}
