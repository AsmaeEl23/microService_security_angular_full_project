package el.asmae.resourcesservice;

import el.asmae.resourcesservice.entities.Resource;
import el.asmae.resourcesservice.enume.Type;
import el.asmae.resourcesservice.repo.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ResourcesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcesServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ResourceRepository resourceRepository){
		return args -> {
			resourceRepository.save(Resource.builder().nom("res1").type(Type.MATERIEL_AUDIO_VUSUEL).build());
			resourceRepository.save(Resource.builder().nom("res2").type(Type.MATERIEL_AUDIO_VUSUEL).build());
			resourceRepository.save(Resource.builder().nom("res3").type(Type.MATERIEL_INF0).build());
			resourceRepository.save(Resource.builder().nom("res4").type(Type.MATERIEL_INF0).build());
		};
	}
}
