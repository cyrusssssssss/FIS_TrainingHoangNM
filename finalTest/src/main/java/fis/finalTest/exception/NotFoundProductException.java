package fis.finalTest.exception;


import fis.finalTest.entity.Product;
import org.springframework.security.core.parameters.P;

public class NotFoundProductException extends ApplicationException{
    private Product product;

    public NotFoundProductException( String message) {
        super(message);
        this.product = product;
    }

    @Override
    public String getErrorCode() {

        return "NOT_FOUND_PRODUCT";

    }

    public Product getCustomer() {
        return this.product;
    }
}
