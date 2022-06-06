package dao;

import core.Evidence;

public interface IEvidence {
    void createEvidence(Evidence evidence);
    void updateEvidence(Evidence evidence);
    void deleteEvidence(Long id);
    Evidence findEvidenceById(Long id);
}
