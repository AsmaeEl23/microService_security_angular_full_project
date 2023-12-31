package el.asmae.reservationservice.DTO;

import lombok.*;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationRequestDto {
    private String nom;
    private String contexte;
    private Date date;
    private Long duree;
    private Long idPersonne;
    private Long resourceId;
}
