package el.asmae.resourcesservice.repo;

import el.asmae.resourcesservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
