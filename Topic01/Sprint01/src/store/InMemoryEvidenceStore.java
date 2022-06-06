package store;

import core.CriminalCase;
import core.Evidence;

import java.util.*;

public class InMemoryEvidenceStore {
    private final Map<Long, Evidence> mapEvidence = new HashMap<>();
    public void insertOrUpdate(Evidence evidence) {
        mapEvidence.put(evidence.getId(), evidence);
    }
    public Evidence findByID(Long id) {

        Collection<Evidence> values = mapEvidence.values();
        List<Evidence> listOfValues = new ArrayList<>(values);

        return listOfValues.stream().filter(criminalCase -> (criminalCase.getId()).equals(id)).findFirst().get();
    }
    public void deleteById(Long id) {
        mapEvidence.remove(id);
    }
}
