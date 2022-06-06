package dao.mem;

import core.Evidence;
import dao.IEvidence;
import store.InMemoryDetectiveStore;
import store.InMemoryEvidenceStore;

public class EvidenceDaoMem implements IEvidence {
    private InMemoryEvidenceStore inMemoryEvidenceStore;
    @Override
    public void createEvidence(Evidence evidence) {
        inMemoryEvidenceStore.insertOrUpdate(evidence);
    }

    @Override
    public void updateEvidence(Evidence evidence) {
        inMemoryEvidenceStore.insertOrUpdate(evidence);
    }

    @Override
    public void deleteEvidence(Long id) {
        inMemoryEvidenceStore.deleteById(id);
    }

    @Override
    public Evidence findEvidenceById(Long id) {
        return inMemoryEvidenceStore.findByID(id);
    }
}
