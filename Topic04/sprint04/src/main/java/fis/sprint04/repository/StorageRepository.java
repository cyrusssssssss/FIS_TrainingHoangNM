package fis.sprint04.repository;


import fis.sprint04.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "storage", path = "storage")

public interface StorageRepository extends JpaRepository<Storage, Long> {
}
