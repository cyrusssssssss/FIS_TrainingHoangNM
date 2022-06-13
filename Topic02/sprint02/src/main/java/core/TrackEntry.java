package core;

import core.enums.TrackAction;

import java.time.LocalDateTime;

public class TrackEntry {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String reason;

    public TrackEntry(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime date, Evidence evidence, Detective detective, TrackAction action, String reason) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.date = date;
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.reason = reason;
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

    public LocalDateTime getDate() {
        return date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public Detective getDetective() {
        return detective;
    }

    public TrackAction getAction() {
        return action;
    }

    public String getReason() {
        return reason;
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
