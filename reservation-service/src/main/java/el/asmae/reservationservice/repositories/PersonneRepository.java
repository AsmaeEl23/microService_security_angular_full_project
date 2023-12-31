package el.asmae.reservationservice.repositories;

import el.asmae.reservationservice.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
