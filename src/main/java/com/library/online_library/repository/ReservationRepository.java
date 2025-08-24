package com.library.online_library.repository;

import com.library.online_library.model.Reservation;
import com.library.online_library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByStatusAndExpirationDateBefore(Reservation.Status status, LocalDate date);
}
