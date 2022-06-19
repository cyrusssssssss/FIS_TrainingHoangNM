package vn.fis.training.ordermanagement.exception;

public abstract class ApplicationException extends RuntimeException{

    public ApplicationException(String message) {
        super(message);
    }

    /**
     * @return: Ma loi duoc khai bao trong @vn.fis.training.service.AppConstant
     */
    public abstract String getErrorCode();
}
