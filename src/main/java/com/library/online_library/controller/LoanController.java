package com.library.online_library.controller;

import com.library.online_library.model.Loan;
import com.library.online_library.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestParam Long userId, @RequestParam Long bookId) {
        return ResponseEntity.ok(loanService.createLoan(userId, bookId));
    }

    @GetMapping("/user/{userId}")
    public List<Loan> getUserLoans(@PathVariable Long userId) {
        return loanService.getLoansByUser(userId);
    }

    @GetMapping("/active")
    public List<Loan> getActiveLoans() {
        return loanService.getActiveLoans();
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Void> returnBook(@PathVariable Long loanId) {
        loanService.markAsReturned(loanId);
        return ResponseEntity.ok().build();
    }
}
