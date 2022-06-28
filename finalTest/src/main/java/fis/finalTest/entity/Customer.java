package fis.finalTest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="tbl_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    private Long id;

    @Column(name="name")
    @NotNull
    @Size(min = 10, max = 100)
    private String name;

    @Column(name="mobile", length = 10)
    @NotNull
    @Size(min = 10, max = 10)
    private String mobile;

    @Column(name="address")
    @NotNull
    @Size(min = 10, max = 100)
    private String address;
    @OneToMany
    private List<Order> orders;
    private String role;
    private String passWord;

}
