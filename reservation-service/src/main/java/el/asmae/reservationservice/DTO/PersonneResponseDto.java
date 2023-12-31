package el.asmae.reservationservice.DTO;

import el.asmae.reservationservice.entities.Reservation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneResponseDto {
    private Long id;
    private String nom;
    private String email;
    private String fonction;
    private List<Reservation> reservations;
}
