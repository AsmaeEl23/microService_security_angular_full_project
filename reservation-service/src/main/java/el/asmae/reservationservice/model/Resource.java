package el.asmae.reservationservice.model;

import el.asmae.reservationservice.enums.Type;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Resource {
    private Long id;
    private String nom;
    private Type type;
}
