package fis.sprint04.repository;



import fis.sprint04.entity.Detective;
import fis.sprint04.dto.DetectiveDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "detective", path = "detective")

public interface DetectiveRepository extends JpaRepository<Detective, Long> {
//    Optional<Detective> findByUserName(String userName);
    Optional<DetectiveDTO> findByUserName(String productName);

}
