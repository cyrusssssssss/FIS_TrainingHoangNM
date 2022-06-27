package fis.sprint04.repository;


import fis.sprint04.entity.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "trackEntry", path = "trackEntry")

public interface TrackEntryRepository extends JpaRepository<TrackEntry, Long> {

}
