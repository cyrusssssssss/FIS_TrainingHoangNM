package fis.sprint04.repository;


import fis.sprint04.entity.CriminalCase;
import fis.sprint04.entity.Detective;
import fis.sprint04.entity.Evidence;
import fis.sprint04.entity.enums.CaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "criminalCase", path = "criminalCase")
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {
    List<CriminalCase> findAllByStatus(CaseStatus status);
    List<CriminalCase> findAllByAssignedUserName(String userName);

}
