package el.asmae.resourcesservice.service;

import el.asmae.resourcesservice.DTO.ResourceRequestDto;
import el.asmae.resourcesservice.DTO.ResourceResponseDto;
import el.asmae.resourcesservice.entities.Resource;
import el.asmae.resourcesservice.mappers.ResourceMapper;
import el.asmae.resourcesservice.repo.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service  @Transactional
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public ResourceResponseDto addResource(ResourceRequestDto resourceRequestDto) {
        Resource resource= resourceMapper.to(resourceRequestDto);
        Resource saveResource=resourceRepository.save(resource);
        ResourceResponseDto resourceResponseDto= resourceMapper.from(saveResource);
        return resourceResponseDto;
    }

    @Override
    public List<ResourceResponseDto> getAllResources() {
        List<Resource> resources = resourceRepository.findAll();
        return resources.stream().map(resourceMapper::from).collect(Collectors.toList());
    }

    @Override
    public ResourceResponseDto getResourceById(Long id) {
        return resourceMapper.from(resourceRepository.findById(id).orElse(null));
    }

    @Override
    public ResourceResponseDto update(Long id, ResourceRequestDto resourceRequestDto) {
        Resource resource= resourceMapper.to(resourceRequestDto);
        resource.setId(id);
        Resource saveResource=resourceRepository.save(resource);
        ResourceResponseDto resourceResponseDto= resourceMapper.from(saveResource);
        return resourceResponseDto;
    }


}
