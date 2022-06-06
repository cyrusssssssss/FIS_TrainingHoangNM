package dao.mem;

import core.Storage;
import dao.IStorage;
import store.InMemoryEvidenceStore;
import store.InMemoryStorageStore;

public class StorageDaoMem implements IStorage {
    private InMemoryStorageStore inMemoryStorageStore;
    @Override
    public void createStorage(Storage storage) {
        inMemoryStorageStore.insertOrUpdate(storage);
    }

    @Override
    public void updateStorage(Storage storage) {
        inMemoryStorageStore.insertOrUpdate(storage);
    }

    @Override
    public void deleteStorage(Long id) {
        inMemoryStorageStore.deleteById(id);
    }

    @Override
    public Storage findStorageById(Long id) {
        return inMemoryStorageStore.findByID(id);
    }
}
