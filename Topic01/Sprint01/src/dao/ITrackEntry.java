package dao;

import core.Evidence;
import core.TrackEntry;

public interface ITrackEntry {
    void createTrackEntry(TrackEntry trackEntry);
    void updateTrackEntry(TrackEntry trackEntry);
    void deleteTrackEntry(Long id);
    TrackEntry findTrackEntryById(Long id);
}
