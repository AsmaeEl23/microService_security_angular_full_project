package el.asmae.reservationservice.service;

import el.asmae.reservationservice.DTO.PersonneResponseDto;
import el.asmae.reservationservice.DTO.ReservationRequestDto;
import el.asmae.reservationservice.DTO.ReservationResponseDto;
import el.asmae.reservationservice.entities.Personne;
import el.asmae.reservationservice.entities.Reservation;
import el.asmae.reservationservice.feign.ResourceRestClient;
import el.asmae.reservationservice.mappers.PersonneMapper;
import el.asmae.reservationservice.mappers.ReservationMapper;
import el.asmae.reservationservice.model.Resource;
import el.asmae.reservationservice.repositories.PersonneRepository;
import el.asmae.reservationservice.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    private ReservationMapper reservationMapper;
    private ReservationRepository reservationRepository;
    private PersonneService personneService;
    private PersonneMapper personneMapper;
    private ResourceRestClient resourceRestClient;
    private PersonneRepository personneRepository;

    public ReservationServiceImpl(ReservationMapper reservationMapper, ReservationRepository reservationRepository, PersonneService personneService, PersonneMapper personneMapper, ResourceRestClient resourceRestClient, PersonneRepository personneRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.personneService = personneService;
        this.personneMapper = personneMapper;
        this.resourceRestClient = resourceRestClient;
        this.personneRepository = personneRepository;
    }

    @Override
    public List<ReservationResponseDto> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            reservation.setPersonne(personneRepository.findById(reservation.getIdPersonne()).get());
            reservation.setResource(resourceRestClient.getResourceById(reservation.getResourceId()));
            reservationRepository.save(reservation);
        }
        return reservations.stream().map(reservationMapper::from).collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDto getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation == null) throw new RuntimeException(String.format("reservation by Id : %d is not found", id));
        Personne personne = personneRepository.findById(reservation.getIdPersonne()).get();
        reservation.setPersonne(personne);
        //RestClient restClient = RestClient.create("http://localhost:8082/resources-service");
        //Resource resource = restClient.get().uri("/Resources/" + reservation.getResourceId()).retrieve().body(new ParameterizedTypeReference<>() {});
        Resource resource = resourceRestClient.getResourceById(reservation.getResourceId());
        reservation.setResource(resource);
        return reservationMapper.from(reservation);
    }
    @Override
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
    @Override
    public ReservationResponseDto saveReservation(ReservationRequestDto reservation){
        return reservationMapper.from(reservationRepository.save(reservationMapper.to(reservation)));
    }
    @Override
    public ReservationResponseDto updateReservation(Long id, ReservationRequestDto reservation){
        Reservation reservation1=reservationRepository.findById(id).orElseThrow();
        if(reservation.getNom() != null) reservation1.setNom(reservation.getNom());
        if(reservation.getDate() != null) reservation1.setDate(reservation.getDate());
        if(reservation.getContexte() != null) reservation1.setContexte(reservation.getContexte());
        if(reservation.getDuree() != null) reservation1.setDuree(reservation.getDuree());
        if(reservation.getIdPersonne() != null) reservation1.setIdPersonne(reservation.getIdPersonne());
        if(reservation.getResourceId() != null) reservation1.setResourceId(reservation.getResourceId());

        return reservationMapper.from(reservationRepository.save(reservation1));
    }

    @Override
    public List<ReservationResponseDto> reservationsByIdPersonne(Long id){
        List<Reservation> reservationList=reservationRepository.findByPersonneId(id);

        return reservationList.stream().map(reservationMapper::from).collect(Collectors.toList());
    }
}
