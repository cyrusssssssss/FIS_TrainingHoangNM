package fis.sprint04.service;





import fis.sprint04.entity.Evidence;

import java.util.List;

public interface EvidenceService {
    List<Evidence> findAll();

    Evidence findById(Long evidenceId);

    void save(Evidence evidence);

    void deleteById(Long evidenceId);
    List<Evidence> findAllByNumber(String number);
}
