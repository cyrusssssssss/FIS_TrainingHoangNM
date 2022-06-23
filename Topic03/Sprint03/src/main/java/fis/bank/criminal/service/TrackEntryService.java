package fis.bank.criminal.service;



import fis.bank.criminal.entity.TrackEntry;

import java.util.List;

public interface TrackEntryService {
    List<TrackEntry> findAll();

    TrackEntry findById(Long trackEntryId);

    void save(TrackEntry trackEntry);

    void deleteById(Long trackEntryId);
}
