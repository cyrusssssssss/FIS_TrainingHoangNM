package vn.fis.training.ordermanagement.exception;


import vn.fis.training.ordermanagement.domain.Order;



public class NotFoundOrderException extends ApplicationException{

    private Order order;

    public NotFoundOrderException( String message) {
        super(message);
        this.order = order;
    }

    @Override
    public String getErrorCode() {

            return "NOT_FOUND_ORDER";

    }

    public Order getCustomer() {
        return this.order;
    }
}
