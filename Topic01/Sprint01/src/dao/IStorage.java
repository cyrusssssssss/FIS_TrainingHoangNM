package dao;

import core.Evidence;
import core.Storage;
import core.TrackEntry;

public interface IStorage {
    void createStorage(Storage storage);
    void updateStorage(Storage storage);
    void deleteStorage(Long id);
    Storage findStorageById(Long id);
}
