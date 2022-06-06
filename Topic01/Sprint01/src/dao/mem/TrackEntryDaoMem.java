package dao.mem;

import core.TrackEntry;
import dao.ITrackEntry;
import store.InMemoryEvidenceStore;
import store.InMemoryTrackEntryStore;

public class TrackEntryDaoMem implements ITrackEntry {
    private InMemoryTrackEntryStore inMemoryTrackEntryStore;
    @Override
    public void createTrackEntry(TrackEntry trackEntry) {
        inMemoryTrackEntryStore.insertOrUpdate(trackEntry);
    }

    @Override
    public void updateTrackEntry(TrackEntry trackEntry) {
        inMemoryTrackEntryStore.insertOrUpdate(trackEntry);

    }

    @Override
    public void deleteTrackEntry(Long id) {
        inMemoryTrackEntryStore.deleteById(id);
    }

    @Override
    public TrackEntry findTrackEntryById(Long id) {
        return inMemoryTrackEntryStore.findByID(id);
    }
}
