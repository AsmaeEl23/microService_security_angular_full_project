package el.asmae.reservationservice.service;

import el.asmae.reservationservice.DTO.ReservationRequestDto;
import el.asmae.reservationservice.DTO.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    List<ReservationResponseDto> getReservations();
    ReservationResponseDto getReservationById(Long id);

    void deleteReservation(Long id);

    ReservationResponseDto saveReservation(ReservationRequestDto reservation);

    ReservationResponseDto updateReservation(Long id, ReservationRequestDto reservation);

    List<ReservationResponseDto> reservationsByIdPersonne(Long id);
}
