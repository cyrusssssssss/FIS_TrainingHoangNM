package core;

import java.time.LocalDateTime;
import java.util.Set;

public class Evidence {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private CriminalCase criminalCase;
    private Storage storage;
    private String number;
    private String itemName;
    private String notes;
    private boolean archived;
    private Set<TrackEntry> trackEntries;

    public Evidence(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, CriminalCase criminalCase, Storage storage, String number, String itemName, String notes, boolean archived, Set<TrackEntry> trackEntries) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archived = archived;
        this.trackEntries = trackEntries;
    }

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public Storage getStorage() {
        return storage;
    }

    public String getNumber() {
        return number;
    }

    public String getItemName() {
        return itemName;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isArchived() {
        return archived;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }
}
