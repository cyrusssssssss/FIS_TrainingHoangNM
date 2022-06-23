package fis.bank.criminal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "evidence")
public class Evidence extends AbstractEntity {
    @ManyToOne

    private CriminalCase criminalCase;
    @ManyToOne
    private Storage storage;
    private String number;
    private String itemName;
    private String notes;
    private boolean archived;
    @OneToMany(mappedBy = "evidence")
    private Set<TrackEntry> trackEntries;


}
