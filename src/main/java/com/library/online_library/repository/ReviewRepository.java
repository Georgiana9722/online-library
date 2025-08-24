package com.library.online_library.repository;

import com.library.online_library.model.Review;
import com.library.online_library.model.Book;
import com.library.online_library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBook(Book book);
    List<Review> findByUser(User user);
}
