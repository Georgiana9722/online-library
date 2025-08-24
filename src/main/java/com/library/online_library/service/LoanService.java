package com.library.online_library.service;

import com.library.online_library.model.Loan;
import java.util.List;

public interface LoanService {
    Loan createLoan(Long UserId, Long bookId);
    List<Loan> getLoansByUser(Long UserId);
    List<Loan> getActiveLoans();
    void markAsReturned(Long loanId);
}
