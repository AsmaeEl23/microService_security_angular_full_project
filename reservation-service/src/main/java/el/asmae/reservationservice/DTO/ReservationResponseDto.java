package el.asmae.reservationservice.DTO;

import el.asmae.reservationservice.entities.Personne;
import el.asmae.reservationservice.model.Resource;
import lombok.*;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationResponseDto {
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private Long duree;
    private Long idPersonne;
    private Long resourceId;
    private Resource resource;
    private Personne personne;
}
