package fis.sprint04.repository;


import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.Evidence;
import fis.sprint04.entity.enums.CaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "evidence", path = "evidence")

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    List<Evidence> findAllByCriminalCaseNumber(String number);
}
