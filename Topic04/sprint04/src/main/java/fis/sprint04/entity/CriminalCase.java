package fis.sprint04.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis.sprint04.entity.enums.CaseStatus;
import fis.sprint04.entity.enums.CaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "criminal_case")
public class CriminalCase extends AbstractEntity{

    @Column(name = "number")
    private String number;
    @Enumerated(EnumType.STRING)
    private CaseType type;
    @Column(name = "sort_des")
    private String sortDescription;
    @Column(name = "detail_des")
    private String detailedDescription;
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    @Column(name = "notes")
    private String notes;
    @OneToMany(mappedBy = "criminalCase")
    @JsonBackReference
    private Set<Evidence> evidenceSet;
    @ManyToOne


    private Detective leadInvestigator;
    @ManyToMany
    @JsonBackReference
    private Set<Detective> assigned;


}
