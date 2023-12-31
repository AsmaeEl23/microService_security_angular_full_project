package el.asmae.resourcesservice.web;

import el.asmae.resourcesservice.DTO.ResourceRequestDto;
import el.asmae.resourcesservice.DTO.ResourceResponseDto;
import el.asmae.resourcesservice.repo.ResourceRepository;
import el.asmae.resourcesservice.service.ResourceServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceRestController {
    private ResourceRepository resourceRepository;
    private ResourceServiceImpl resourceService;

    public ResourceRestController(ResourceRepository resourceRepository, ResourceServiceImpl resourceService) {
        this.resourceRepository = resourceRepository;
        this.resourceService = resourceService;
    }
    @GetMapping("/resources")
    public List<ResourceResponseDto> getAllResources(){
        return resourceService.getAllResources();
    }
    @GetMapping("/resource/{id}")
    public ResourceResponseDto getResourceById(@PathVariable Long id){
        return resourceService.getResourceById(id);
    }
    @PostMapping("/resource")
    public ResourceResponseDto save(@RequestBody ResourceRequestDto resource){
        return resourceService.addResource(resource);
    }

    @PutMapping("/resource/{id}")
    public ResourceResponseDto update(@PathVariable Long id, @RequestBody ResourceRequestDto resource){
        return resourceService.update(id,resource);
    }
    @DeleteMapping("/resource/{id}")
    public void delete(@PathVariable Long id){
        resourceRepository.deleteById(id);
    }
}
