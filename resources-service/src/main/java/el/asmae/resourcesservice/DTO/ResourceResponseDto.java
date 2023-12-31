package el.asmae.resourcesservice.DTO;

import el.asmae.resourcesservice.enume.Type;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class ResourceResponseDto {
    private Long id;
    private String nom;
    private Type type;
}
