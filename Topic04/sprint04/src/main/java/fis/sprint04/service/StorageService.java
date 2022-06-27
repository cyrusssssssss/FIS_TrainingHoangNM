package fis.sprint04.service;





import fis.sprint04.entity.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> findAll();

    Storage findById(Long storageId);

    void save(Storage storage);

    void deleteById(Long storageId);
}
