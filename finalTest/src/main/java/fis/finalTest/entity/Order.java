package fis.finalTest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tbl_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    private Long id;
    @Column(name="order_datetime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @NotNull
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name="total_amount")
    private Double totalAmount;



    @Column(name="status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderStatus status;


}
