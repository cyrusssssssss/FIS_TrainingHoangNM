package fis.finalTest.controller;

import fis.finalTest.exception.FallStatusForUpdateException;
import fis.finalTest.exception.NotFoundCustomerException;
import fis.finalTest.exception.NotFoundOrderException;
import fis.finalTest.exception.NotFoundProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static fis.finalTest.constant.Constant.*;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            NotFoundOrderException.class
    })
    protected ResponseEntity<ErrorMessage> handleOrderNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(ORDER_NOT_FOUND).message(exception.getMessage()).build());
    }

    @ExceptionHandler(value = {
            NotFoundProductException.class
    })
    protected ResponseEntity<ErrorMessage> handleProductNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(PRODUCT_NOT_FOUND).message(exception.getMessage()).build());
    }
    @ExceptionHandler(value = {
            NotFoundCustomerException.class
    })
    protected ResponseEntity<ErrorMessage> handleCustomerNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(CUSTOMER_NOT_FOUND).message(exception.getMessage()).build());
    }
    @ExceptionHandler(value = {
            FallStatusForUpdateException.class
    })
    protected ResponseEntity<ErrorMessage> handleFallStatus(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder().code(FALL_STATUS).message(exception.getMessage()).build());
    }
}
