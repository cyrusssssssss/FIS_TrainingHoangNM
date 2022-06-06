package dao;

public class InputComponent implements IValidation {
    private IValidation validation;
    private String data;

    public InputComponent(IValidation validation, String data) {
        this.validation = validation;
        this.data = data;
    }

    public IValidation getValidation() {
        return validation;
    }

    public String getData() {
        return data;
    }

    public void setValidation(IValidation validation) {
        this.validation = validation;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void display(){
        //TODO
    }

    @Override
    public boolean validate(String data) {
        return false;
    }
}
