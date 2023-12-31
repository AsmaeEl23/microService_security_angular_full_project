package el.asmae.reservationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String fonction;
    @OneToMany(mappedBy = "personne")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reservation> reservations;
}
