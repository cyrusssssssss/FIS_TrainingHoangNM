package core;

import core.enums.CaseStatus;
import core.enums.CaseType;

import java.time.LocalDateTime;
import java.util.Set;

public class CriminalCase {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String number;
    private CaseType type;
    private String sortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidenceSet;
    private Detective leadInvestigator;
    private Set<Detective> assigned;

    public CriminalCase(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String number,
                        CaseType type, String sortDescription, String detailedDescription, CaseStatus status,
                        String notes, Set<Evidence> evidenceSet, Detective leadInvestigator, Set<Detective> assigned) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.number = number;
        this.type = type;
        this.sortDescription = sortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.evidenceSet = evidenceSet;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
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

    public String getNumber() {
        return number;
    }

    public CaseType getType() {
        return type;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
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

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }
}
