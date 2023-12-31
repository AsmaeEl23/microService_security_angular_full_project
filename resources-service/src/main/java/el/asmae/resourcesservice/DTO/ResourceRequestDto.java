package el.asmae.resourcesservice.DTO;

import el.asmae.resourcesservice.enume.Type;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class ResourceRequestDto {
    private String nom;
    private Type type;
}
