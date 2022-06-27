package fis.sprint04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Set<Evidence> evidenceSet;


}
