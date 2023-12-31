package el.asmae.reservationservice.repositories;

import el.asmae.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByPersonneId(Long personneId);
}
