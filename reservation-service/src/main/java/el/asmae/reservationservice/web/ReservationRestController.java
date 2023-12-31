package el.asmae.reservationservice.web;

import el.asmae.reservationservice.DTO.PersonneRequestDto;
import el.asmae.reservationservice.DTO.PersonneResponseDto;
import el.asmae.reservationservice.DTO.ReservationRequestDto;
import el.asmae.reservationservice.DTO.ReservationResponseDto;
import el.asmae.reservationservice.mappers.PersonneMapper;
import el.asmae.reservationservice.service.PersonneServiceImpl;
import el.asmae.reservationservice.service.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationRestController {
    private PersonneServiceImpl personneService;
    private ReservationServiceImpl reservationServiceImp;
    private PersonneMapper personneMapper;

    public ReservationRestController(PersonneServiceImpl
                                             personneService, ReservationServiceImpl reservationServiceImp, PersonneMapper personneMapper) {
        this.personneService = personneService;
        this.reservationServiceImp = reservationServiceImp;
        this.personneMapper = personneMapper;
    }

    @GetMapping("/reservations")
    public List<ReservationResponseDto> getAllReservations(){
        return reservationServiceImp.getReservations();
    }

    @GetMapping("/reservations/{id}")
    public ReservationResponseDto getReservationById(@PathVariable Long id){
        return reservationServiceImp.getReservationById(id);
    }

    @PostMapping("/reservation")
    public ReservationResponseDto addReservation(@RequestBody ReservationRequestDto reservationRequestDto){
        return reservationServiceImp.saveReservation(reservationRequestDto);
    }

    @PostMapping("/reservation/{id}")
    public ReservationResponseDto updateReservation(@PathVariable Long id,@RequestBody ReservationRequestDto reservationRequestDto){
        return reservationServiceImp.updateReservation(id,reservationRequestDto);
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationServiceImp.deleteReservation(id);
    }

    @GetMapping("/reservations/idPersonne/{id}")
    public List<ReservationResponseDto> reservationsByIdPersonne(@PathVariable Long id){
        return reservationServiceImp.reservationsByIdPersonne(id);
    }

    @PostMapping("/personne")
    public PersonneResponseDto addPersonne(@RequestBody PersonneRequestDto personneRequestDto){
        return personneService.savePersonne(personneRequestDto);
    }

    @GetMapping("/personnes")
    public List<PersonneResponseDto> getAllPersonnes(){
        return personneService.getPersonnes();
    }
    @GetMapping("/personne/{id}")
    public PersonneResponseDto getPersonneById(@PathVariable Long id){
        return personneService.getPersonneById(id);
    }

    @PostMapping("/personne/{id}")
    public PersonneResponseDto updatePersonne(@PathVariable Long id,@RequestBody PersonneRequestDto personneRequestDto){
        return personneService.updatePersonne(id,personneRequestDto);
    }

    @DeleteMapping("/personne/{id}")
    public void deletePersonne(@PathVariable Long id){
        personneService.deletePersonne(id);
    }
}
