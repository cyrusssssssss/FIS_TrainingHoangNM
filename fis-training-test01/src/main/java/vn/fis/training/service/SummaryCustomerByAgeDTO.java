package vn.fis.training.service;

public class SummaryCustomerByAgeDTO {
    private int age;
    private int count;

    //TODO: Setters, Getter, Constructors
    public SummaryCustomerByAgeDTO(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
