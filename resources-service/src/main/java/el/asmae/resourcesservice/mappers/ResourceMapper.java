package el.asmae.resourcesservice.mappers;

import el.asmae.resourcesservice.DTO.ResourceRequestDto;
import el.asmae.resourcesservice.DTO.ResourceResponseDto;
import el.asmae.resourcesservice.entities.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public ResourceResponseDto from(Resource resource){
        return modelMapper.map(resource, ResourceResponseDto.class);
    }

    public Resource to(ResourceRequestDto resourceRequestDto){
        return modelMapper.map(resourceRequestDto, Resource.class);
    }
}
