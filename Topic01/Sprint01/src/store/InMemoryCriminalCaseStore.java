package store;

import core.CriminalCase;
import core.Detective;

import java.util.*;

public class InMemoryCriminalCaseStore {
    private final Map<Long, CriminalCase> mapCriminalCase = new HashMap<>();
    public void insertOrUpdate(CriminalCase criminalCase) {
        mapCriminalCase.put(criminalCase.getId(), criminalCase);
    }
    public CriminalCase findByID(Long id) {

        Collection<CriminalCase> values = mapCriminalCase.values();
        List<CriminalCase> listOfValues = new ArrayList<CriminalCase>(values);

        return listOfValues.stream().filter(criminalCase -> (criminalCase.getId()).equals(id)).findFirst().get();
    }
    public void deleteById(Long id) {
        mapCriminalCase.remove(id);
    }
}
