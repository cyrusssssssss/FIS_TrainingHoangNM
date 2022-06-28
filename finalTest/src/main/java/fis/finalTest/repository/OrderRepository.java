package fis.finalTest.repository;

import fis.finalTest.entity.Customer;
import fis.finalTest.entity.Order;
import fis.finalTest.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
     Page<Order> findAllByStatus(OrderStatus orderStatus, Pageable page);


}
