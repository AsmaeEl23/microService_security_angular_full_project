package el.asmae.reservationservice.service;

import el.asmae.reservationservice.DTO.PersonneRequestDto;
import el.asmae.reservationservice.DTO.PersonneResponseDto;
import el.asmae.reservationservice.entities.Personne;
import el.asmae.reservationservice.entities.Reservation;
import el.asmae.reservationservice.mappers.PersonneMapper;
import el.asmae.reservationservice.repositories.PersonneRepository;
import el.asmae.reservationservice.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService{
    private PersonneMapper personneMapper;
    private PersonneRepository personneRepository;
    private ReservationRepository reservationRepository;

    public PersonneServiceImpl(PersonneMapper personneMapper, PersonneRepository personneRepository, ReservationRepository reservationRepository) {
        this.personneMapper = personneMapper;
        this.personneRepository = personneRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<PersonneResponseDto> getPersonnes() {
        List<Personne> personnes = personneRepository.findAll();
        for (Personne personne : personnes) {
            List<Reservation> reservationList=reservationRepository.findByPersonneId(personne.getId());
            personne.setReservations(reservationList);
            personneRepository.save(personne);
        }
        return personnes.stream().map(personneMapper::from).collect(Collectors.toList());
    }

    @Override
    public PersonneResponseDto getPersonneById(Long id) {
        Personne personne = personneRepository.findById(id).orElse(null);
        if (personne == null) throw new RuntimeException(String.format("personne by Id : %d is not found", id));
        List<Reservation> reservationList=reservationRepository.findByPersonneId(id);
        personne.setReservations(reservationList);
        personneRepository.save(personne);
        return personneMapper.from(personne);
    }
    @Override
    public PersonneResponseDto savePersonne(PersonneRequestDto personneRequestDto){
        return personneMapper.from(personneRepository.save(personneMapper.to(personneRequestDto)));
    }
    @Override
    public void deletePersonne(Long id){
        personneRepository.deleteById(id);
    }

    @Override
    public PersonneResponseDto updatePersonne(Long id, PersonneRequestDto personneRequestDto) {
        Personne personne=personneRepository.findById(id).orElseThrow();
        if(personneRequestDto.getNom() != null) personne.setNom(personneRequestDto.getNom());
        if(personneRequestDto.getEmail() != null) personne.setEmail(personneRequestDto.getEmail());
        if(personneRequestDto.getFonction() != null) personne.setFonction(personneRequestDto.getFonction());

        return personneMapper.from(personneRepository.save(personne));
    }
}
