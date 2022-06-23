package fis.bank.criminal.entity;


import fis.bank.criminal.entity.enums.CaseStatus;
import fis.bank.criminal.entity.enums.CaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

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

    private Set<Evidence> evidenceSet;
    @ManyToOne
    private Detective leadInvestigator;
    @ManyToMany
    private Set<Detective> assigned;


}
