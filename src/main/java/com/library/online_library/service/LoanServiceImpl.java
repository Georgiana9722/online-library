package com.library.online_library.service;

import com.library.online_library.model.Book;
import com.library.online_library.model.Loan;
import com.library.online_library.model.User;
import com.library.online_library.repository.LoanRepository;
import com.library.online_library.repository.UserRepository;
import com.library.online_library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Loan createLoan(Long userId, Long bookId){
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isEmpty() || bookOpt.isEmpty()) {
            throw new RuntimeException("User or Book not found");
        }

        User user = userOpt.get();
        Book book = bookOpt.get();


        // Verificare dacă deja are împrumut activ
        Optional<Loan> existingLoan = loanRepository.findByUserAndBookAndReturnedFalse(user, book);
        if (existingLoan.isPresent()) {
            throw new RuntimeException("Cartea este deja împrumutată de acest utilizator!");
        }

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(14));
        loan.setReturned(false);

        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getLoansByUser(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    @Override
    public List<Loan> getActiveLoans() {
        return loanRepository.findByReturnedFalse();
    }

    @Override
    public void markAsReturned(Long loanId) {
        Optional<Loan> loanOpt = loanRepository.findById(loanId);
        if (loanOpt.isPresent()) {
            Loan loan = loanOpt.get();
            loan.setReturned(true);
            loanRepository.save(loan);
        }
    }
}
