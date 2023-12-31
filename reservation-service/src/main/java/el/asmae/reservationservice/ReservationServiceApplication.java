package el.asmae.reservationservice;

import el.asmae.reservationservice.entities.Personne;
import el.asmae.reservationservice.entities.Reservation;
import el.asmae.reservationservice.repositories.PersonneRepository;
import el.asmae.reservationservice.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ReservationRepository reservationRepository, PersonneRepository personneRepository){
		return args -> {
			for (int i = 0; i <10; i++) {
				Personne personne = Personne.builder().nom("personne" + i).email("personne" + i + "@gmail.com").fonction("fonction" + i).build();
				personneRepository.save(personne);
			}

			reservationRepository.saveAll(List.of(
					Reservation.builder().nom("reserv1").contexte("info").date(new Date()).duree(300L).idPersonne(5L).resourceId(2L).build(),
					Reservation.builder().nom("reserv2").contexte("enregistrement").date(new Date()).duree(100L).idPersonne(6L).resourceId(3L).build()
			));
		};
	}
}
