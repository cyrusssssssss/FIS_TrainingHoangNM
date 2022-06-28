package fis.finalTest.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	@Id
	@Column(name = "code")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	@NotNull
	@Size(min = 10, max = 100)
	private String name;

	@Column(name = "price")
	@NotNull
	@DecimalMin( value = "0.00")
	private double price;

	@Column(name = "available")
	@NotNull
	@DecimalMin( value = "0")
	private Long available;
	
}
