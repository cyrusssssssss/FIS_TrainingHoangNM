package fis.bank.criminal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "storage")
public class Storage extends AbstractEntity{

    private String name;
    private String location;
    @OneToMany(mappedBy = "storage")
    private Set<Evidence> evidenceSet;


}
