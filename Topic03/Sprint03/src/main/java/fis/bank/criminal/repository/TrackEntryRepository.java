package fis.bank.criminal.repository;

import fis.bank.criminal.entity.TrackEntry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackEntryRepository extends JpaRepository<TrackEntry, Long> {
}
