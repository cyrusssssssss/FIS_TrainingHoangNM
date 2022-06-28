package fis.finalTest.controller;

import fis.finalTest.dto.AddOrderItemDTO;
import fis.finalTest.dto.CreateOrderDTO;
import fis.finalTest.dto.OrderDTO;
import fis.finalTest.dto.RemoveItemDTO;
import fis.finalTest.entity.Order;
import fis.finalTest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
@PreAuthorize("hasRole('ROLE_ORDER')")
@Slf4j
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/findById/{orderId}")
    public OrderDTO findById(@PathVariable(name="orderId")Long orderId) {
        return orderService.findById(orderId);
    }
    @PutMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO createOrderDTO){
//        try {
            return new ResponseEntity<>(orderService.addOrder(createOrderDTO), HttpStatus.OK);
//        }catch (Exception e){
//
//        }
    }
    @DeleteMapping("/{orderId}")
    public  ResponseEntity<Order> deleteOrder(@PathVariable(name="orderId") Long orderId){
        return new ResponseEntity<>(orderService.deleteOrder(orderId),HttpStatus.OK);
    }
    @PostMapping("/addOrderItem")
    public ResponseEntity<Order> addOrderItem(@RequestBody AddOrderItemDTO addOrderItemDTO){
        return  new ResponseEntity<>(orderService.addOrderItem(addOrderItemDTO),HttpStatus.OK);
    }
    @PostMapping("/removeOrderItem")
    public ResponseEntity<Order> removeOrderItem(@RequestBody RemoveItemDTO removeItemDTO){
        return  new ResponseEntity<>(orderService.removeOrderItem(removeItemDTO),HttpStatus.OK);
    }
    @PostMapping("/paid/{orderId}")
    public  ResponseEntity<Order> paid(@PathVariable(name="orderId") Long orderId){
        return  new ResponseEntity<>(orderService.paid(orderId),HttpStatus.OK);
    }
    @PostMapping("/cancel/{orderId}")
    public  ResponseEntity<Order> delete(@PathVariable(name="orderId") Long orderId){
        return  new ResponseEntity<>(orderService.cancel(orderId),HttpStatus.OK);
    }
}


/*
* GET http://localhost:8899/api/order/{pageNumber}/pageSize
* GET http://localhost:8899/api/order?pageNumber=0&pageSiz=10
* Tat ca succ: 200
* Exception : 500 : Internal Server Error
* Http.NotFound --> Customer Not Found
* */

