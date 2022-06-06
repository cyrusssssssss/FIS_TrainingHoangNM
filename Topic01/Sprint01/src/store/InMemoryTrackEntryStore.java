package store;

import core.Evidence;
import core.TrackEntry;

import java.util.*;

public class InMemoryTrackEntryStore {
    private final Map<Long, TrackEntry> mapTrack = new HashMap<>();
    public void insertOrUpdate(TrackEntry trackEntry) {
        mapTrack.put(trackEntry.getId(), trackEntry);
    }
    public TrackEntry findByID(Long id) {

        Collection<TrackEntry> values = mapTrack.values();
        List<TrackEntry> listOfValues = new ArrayList<>(values);

        return listOfValues.stream().filter(trackEntry -> (trackEntry.getId()).equals(id)).findFirst().get();
    }
    public void deleteById(Long id) {
        mapTrack.remove(id);
    }
}
