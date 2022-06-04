package vn.fis.training.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    /** ID cua Customer la duy nhat trong toan bo he thong
       Su dung @java.util.UUID de tao id gan cho tung customer
    */
    private String id;

    /** Constraints:
        1. Khong duoc trong (NOT NULL OR BLANK)
        2. Do dai tu tu 5 den 50 ky tu, chi bao gom ky tu a->z, A->Z va khong trang (Blank).
        3. Truoc khi cap nhat vao he thong truong ten phai duoc chuan hoa.
            Qui tac chuan hoa:
                *. Bo cac ky tu trang o dau va cuoi
                *. Upper case chu cai dau tien truoc cac tu
                   VD: nGuyen van    BinH      -> Nguyen Van Binh
    **/
    private String name;
    /** Constraints:
        1. Khong duoc trong
        2. Tinh toan de khong cho phep nhap Customer nho hon 10 tuoi so voi thoi diem hien tai
     **/
    private LocalDate birthDay;
    /** Constraints:
    *   1. Do dai 10 ky tu bat dau bang ky tu 0, chi bao gom cac so tu 0->9
     *  2. So dien thoai la duy nhat trong toan bo he thong. Duoc su dung de kiem tra duplicate khach hang
     *  3. Chuan hoa lai truong so dien thoai truoc khi cap nhat vao he thong. Bo cac ky tu trang o dau, giua va cuoi
     *     Vidu: 0921 000 008 --> 0921000008
    * */
    private String mobile;

    /** Constraints:
     * NOT NULL
     * */

    private CustomerStatus status;

    /**
     * Thoi gian tao doi tuong. mac dinh la thoi diem hien tai
     */

    private LocalDateTime createDateTime;

    // TODO: Implement Getters, Setters, Constructors, Equals

    public Customer(String name, LocalDate birthDay, String mobile, CustomerStatus status, LocalDateTime createDateTime) {
        this.id = UUID.randomUUID().toString();
        this.name = name;

        this.birthDay = birthDay;
        this.mobile = mobile;
        this.status = status;
        this.createDateTime = createDateTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getMobile() {
        return mobile;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setId(String id) {
        this.id = UUID.randomUUID().toString();
    }



    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId()) && getName().equals(customer.getName()) && getBirthDay().equals(customer.getBirthDay()) && getMobile().equals(customer.getMobile()) && getStatus() == customer.getStatus() && getCreateDateTime().equals(customer.getCreateDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthDay(), getMobile(), getStatus(), getCreateDateTime());
    }
    public Customer(){

    }


}
