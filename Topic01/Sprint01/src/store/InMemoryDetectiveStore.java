package store;

import core.Detective;

import java.util.*;

public class InMemoryDetectiveStore {
    private final Map<Long, Detective> mapDetective = new HashMap<>();
    public void insertOrUpdate(Detective detective) {
        mapDetective.put(detective.getId(),detective);
    }
    public Detective findByID(Long id) {

        Collection<Detective> values = mapDetective.values();
        List<Detective> listOfValues = new ArrayList<Detective>(values);

        return listOfValues.stream().filter(detective -> (detective.getId()).equals(id)).findFirst().get();
    }
    public void deleteById(Long id) {
        mapDetective.remove(id);
    }
}
