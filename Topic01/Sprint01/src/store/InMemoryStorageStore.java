package store;

import core.Storage;
import core.TrackEntry;

import java.util.*;

public class InMemoryStorageStore {
    private final Map<Long, Storage> mapStorage = new HashMap<>();
    public void insertOrUpdate(Storage storage) {
        mapStorage.put(storage.getId(), storage);
    }
    public Storage findByID(Long id) {

        Collection<Storage> values = mapStorage.values();
        List<Storage> listOfValues = new ArrayList<>(values);

        return listOfValues.stream().filter(storage -> (storage.getId()).equals(id)).findFirst().get();
    }
    public void deleteById(Long id) {
        mapStorage.remove(id);
    }
}
