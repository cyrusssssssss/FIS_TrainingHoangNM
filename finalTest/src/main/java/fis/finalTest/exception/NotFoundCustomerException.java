package fis.finalTest.exception;

import fis.finalTest.entity.Customer;
import fis.finalTest.entity.Order;

public class NotFoundCustomerException extends ApplicationException{
    private Customer customer;

    public NotFoundCustomerException( String message) {
        super(message);
        this.customer = customer;
    }
    @Override
    public String getErrorCode() {
        return "NOT_FOUND_CUSTOMER";
    }
    public Customer getCustomer() {
        return this.customer;
    }
}
