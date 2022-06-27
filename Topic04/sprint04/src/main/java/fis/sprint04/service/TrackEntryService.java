package fis.sprint04.service;





import fis.sprint04.entity.TrackEntry;

import java.util.List;

public interface TrackEntryService {
    List<TrackEntry> findAll();

    TrackEntry findById(Long trackEntryId);

    void save(TrackEntry trackEntry);

    void deleteById(Long trackEntryId);
}
