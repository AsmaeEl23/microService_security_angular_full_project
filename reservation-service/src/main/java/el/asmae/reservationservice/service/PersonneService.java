package el.asmae.reservationservice.service;

import el.asmae.reservationservice.DTO.PersonneRequestDto;
import el.asmae.reservationservice.DTO.PersonneResponseDto;

import java.util.List;

public interface PersonneService {
    List<PersonneResponseDto> getPersonnes();
    PersonneResponseDto getPersonneById(Long id);

    PersonneResponseDto savePersonne(PersonneRequestDto personneRequestDto);

    void deletePersonne(Long id);

    PersonneResponseDto updatePersonne(Long id, PersonneRequestDto personneRequestDto);
}
