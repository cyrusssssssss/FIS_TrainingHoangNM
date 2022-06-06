package dao.mem;

import core.CriminalCase;
import dao.ICriminalCase;
import store.InMemoryCriminalCaseStore;

public class CriminalCaseDaoMem implements ICriminalCase {
    private InMemoryCriminalCaseStore inMemoryCriminalCaseStore;
    @Override
    public void createCriminalCase(CriminalCase criminalCase) {
        inMemoryCriminalCaseStore.insertOrUpdate(criminalCase);
    }

    @Override
    public void updateCriminalCase(CriminalCase criminalCase) {
        inMemoryCriminalCaseStore.insertOrUpdate(criminalCase);
    }

    @Override
    public void deleteCriminalCase(Long id) {
        inMemoryCriminalCaseStore.deleteById(id);
    }

    @Override
    public CriminalCase findCriminalCaseById(Long id) {
        return inMemoryCriminalCaseStore.findByID(id);
    }
}
