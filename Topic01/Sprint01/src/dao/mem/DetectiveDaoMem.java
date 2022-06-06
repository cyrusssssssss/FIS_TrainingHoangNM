package dao.mem;

import core.Detective;
import dao.IDetective;
import store.InMemoryDetectiveStore;

public class DetectiveDaoMem implements IDetective {
    private InMemoryDetectiveStore inMemoryDetectiveStore;

    @Override
    public void createDetective(Detective detective) {
        inMemoryDetectiveStore.insertOrUpdate(detective);
    }

    @Override
    public void updateDetective(Detective detective) {
        inMemoryDetectiveStore.insertOrUpdate(detective);
    }

    @Override
    public void deleteDetective(Long id) {
        inMemoryDetectiveStore.deleteById(id);
    }
    @Override
    public Detective findDetectiveById(Long id) {
        return inMemoryDetectiveStore.findByID(id);
    }
}
