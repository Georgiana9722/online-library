package com.library.online_library.service;

import com.library.online_library.repository.LoanRepository;
import com.library.online_library.model.Loan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    @Test
    void testSaveLoan() {
        Loan loan = new Loan();
        loan.setId(1L);

        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        Loan result = loanService.saveLoan(loan);

        assertEquals(1L, result.getId());
    }
}
