package com.library.online_library.service;

import com.library.online_library.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getReservationsByUserId(Long userId);
}
