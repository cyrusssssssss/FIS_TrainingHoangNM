package core;

import core.enums.EmployeeStatus;
import core.enums.Rank;

import java.time.LocalDateTime;
import java.util.Set;

public class Detective {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String userName;
    private String firstName;
    private String lastName;
    private String passWord;
    private LocalDateTime hiringDate;
    private String badgeNumber;
    private Rank rank;
    private boolean armed;
    private EmployeeStatus status;
    private Set<CriminalCase> criminalCases;
    private Set<TrackEntry> trackEntries;
    private Long idCriminal;
    public Detective(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String userName,
                     String firstName, String lastName, String passWord, LocalDateTime hiringDate, String badgeNumber,
                     Rank rank, boolean armed, EmployeeStatus status, Set<CriminalCase> criminalCases,
                     Set<TrackEntry> trackEntries, Long idCriminal) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.hiringDate = hiringDate;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
        this.idCriminal = idCriminal;
    }
    public Detective(){}
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

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isArmed() {
        return armed;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public Set<CriminalCase> getCriminalCases() {
        return criminalCases;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setArmed(boolean armed) {
        this.armed = armed;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public void setCriminalCases(Set<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    public Long getIdCriminal() {
        return idCriminal;
    }

    public void setIdCriminal(Long idCriminal) {
        this.idCriminal = idCriminal;
    }

}
