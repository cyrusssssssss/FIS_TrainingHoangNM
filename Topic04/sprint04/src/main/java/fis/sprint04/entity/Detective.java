package fis.sprint04.entity;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis.sprint04.entity.enums.EmployeeStatus;
import fis.sprint04.entity.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "detective")
public class Detective extends AbstractEntity{
    @Column(name = "username", unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private String passWord;
    private LocalDateTime hiringDate;
    private String badgeNumber;
    @Column(name = "rank_detective")
    @Enumerated(EnumType.STRING)
    private Rank rank;
    private Boolean armed;
    @Column(name = "status_employee")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @ManyToMany(mappedBy = "assigned", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<CriminalCase> criminalCases;
    @OneToMany(mappedBy = "detective")
    @JsonBackReference
    private Set<TrackEntry> trackEntries;
    private Long idCriminal;


}
