package el.asmae.reservationservice.entities;

import el.asmae.reservationservice.model.Resource;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private Long duree;
    private Long idPersonne;
    private Long resourceId;
    @Transient //Resource won't be persisted to the database.
    private Resource resource;
    @ManyToOne
    private Personne personne;
}
