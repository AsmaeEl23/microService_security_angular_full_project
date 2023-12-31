package el.asmae.reservationservice.mappers;

import el.asmae.reservationservice.DTO.PersonneRequestDto;
import el.asmae.reservationservice.DTO.PersonneResponseDto;
import el.asmae.reservationservice.entities.Personne;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonneMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public PersonneResponseDto from(Personne personne){
        return modelMapper.map(personne, PersonneResponseDto.class);
    }

    public Personne to(PersonneRequestDto personneRequestDto){
        return modelMapper.map(personneRequestDto, Personne.class);
    }
}
