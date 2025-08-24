package com.library.online_library.service;

import com.library.online_library.model.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Review review);
    List<Review> getReviewsByBookId(Long bookId);
}
