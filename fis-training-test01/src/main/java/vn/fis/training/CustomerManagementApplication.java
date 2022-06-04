package vn.fis.training;


import vn.fis.training.domain.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CustomerManagementApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Fis Java Training Course!" );
        Customer ct = new Customer();
        ct.setName("   NgUyen minH   hOang");
        System.out.println(ct.getName());
        LocalDate localDate = LocalDate.parse("2001-09-22");
        LocalDate localDate1 = LocalDate.now();
        int is = Period.between(localDate, localDate1).getYears();

        System.out.println(is);
    }
    // TODO: Implement method to test all CustomerService




}
