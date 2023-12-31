package el.asmae.reservationservice.feign;

import el.asmae.reservationservice.entities.Personne;
import el.asmae.reservationservice.model.Resource;
import el.asmae.reservationservice.security.FeignAdapter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "resource-service", configuration = FeignAdapter.class)
public interface ResourceRestClient {
    @GetMapping("/resource/{id}")
    Resource getResourceById(@PathVariable Long id);

    @PostMapping("/resource")
    Resource save(@RequestBody Resource resource);

    @GetMapping("/resources")
    List<Resource> getAllResources();
}
