package el.asmae.resourcesservice.service;

import el.asmae.resourcesservice.DTO.ResourceRequestDto;
import el.asmae.resourcesservice.DTO.ResourceResponseDto;

import java.util.List;

public interface ResourceService  {
     ResourceResponseDto addResource(ResourceRequestDto resourceRequestDto);
     List<ResourceResponseDto> getAllResources();
     ResourceResponseDto getResourceById(Long id);
     ResourceResponseDto update(Long id, ResourceRequestDto resourceRequestDto);
}
