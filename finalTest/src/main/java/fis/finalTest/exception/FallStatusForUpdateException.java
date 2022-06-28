package fis.finalTest.exception;

import fis.finalTest.entity.Customer;

public class FallStatusForUpdateException extends ApplicationException{


    public FallStatusForUpdateException( String message) {
        super(message);

    }
    @Override
    public String getErrorCode() {
        return "FALL_STATUS";
    }

}
