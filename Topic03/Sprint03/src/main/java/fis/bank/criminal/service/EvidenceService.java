package fis.bank.criminal.service;



import fis.bank.criminal.entity.Evidence;

import java.util.List;

public interface EvidenceService {
    List<Evidence> findAll();

    Evidence findById(Long evidenceId);

    void save(Evidence evidence);

    void deleteById(Long evidenceId);
}
