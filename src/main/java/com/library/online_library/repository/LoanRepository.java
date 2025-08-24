package com.library.online_library.repository;

import com.library.online_library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.online_library.model.Book;
import com.library.online_library.model.User;

import java.util.Optional;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
    List<Loan> findByReturnedFalse(); // împrumuturi active

    Optional<Loan> findByUserAndBookAndReturnedFalse(User user, Book book);
}
