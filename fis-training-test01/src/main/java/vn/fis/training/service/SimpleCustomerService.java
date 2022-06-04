package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;
    private Map<String, Customer> mapCustomer = new HashMap<String, Customer>();
    @Override
    public Customer findById(String id) {
        if(isNull(id)){
            throw  new IllegalArgumentException("Chua nhap ID");
        }
        List<Customer> list = customerStore.findAll().stream().filter(customer -> customer.getId().equals(id))
                .collect(Collectors.toList());

        return list.get(0);
    }
    private boolean isNull(String id){
        if(id==null){
            return false;
        }
        if(id.trim().length()==0){
            return false;
        }
        return true;
    }
    @Override
    public Customer createCustomer(Customer customer) {
        validate(customer);
        checkExist(customer);
        chuanHoaVaDoDai(customer);
        validateBirthday(customer);
        validatePhone(customer);
        customerStore.insertOrUpdate(customer);
        return customer;

    }
    private void chuanHoaVaDoDai(Customer customer){

        String s = customer.getName();
        boolean checkName = true;
        for(int i = 0; i < s.length(); i++){
            if( s.charAt(i) < 'z'&& s.charAt(i) > 'a' || s.charAt(i) < 'Z'&& s.charAt(i)>'A'){
                checkName = true;
            }
            else {
                checkName = false;
            }
        }
        if(s.length() < 5 || s.length()>50){
            throw new InvalidCustomerException(customer,"do dai ten qua ngan hoac qua dai");
        }
        else if(!checkName){
            throw new InvalidCustomerException(customer,"sai dinh dang ten");
        }
        else {
            s = s.trim();
            String[] ss = s.split("\\s+");
            StringBuilder sss = new StringBuilder("");
            for (int i = 0; i < ss.length; i++) {
                ss[i] = ss[i].toLowerCase();
                sss.append(Character.toUpperCase(ss[i].charAt(0)));
                sss.append(ss[i].substring(1, ss[i].length()));
                sss.append(" ");
            }

            customer.setName(sss.toString());
        }
    }
    private void validate(Customer customer){
        if(isNull(customer.getName())){
            throw new InvalidCustomerException(customer,"ten bi trong");
        }
        if(isNull(customer.getMobile())){
            throw new InvalidCustomerException(customer,"sdt bi trong");
        }

    }
    private void validateBirthday(Customer customer){

        LocalDate localDate1 = LocalDate.now();
        int is = Period.between(customer.getBirthDay(), localDate1).getYears();
        if(is < 10){
            throw new InvalidCustomerException(customer,"Tuoi phai lon hon 10");
        }

    }
    private void validatePhone(Customer customer){

        String phone = customer.getMobile();
        if(phone.length() != 10 || phone.charAt(0) != 0  ){
            throw  new InvalidCustomerException(customer,"So dien thoai khong hop le");
        }
        else {
            phone = phone.trim();
            String[] ss = phone.split("\\s+");
            StringBuilder sss = new StringBuilder("");
            for (int i = 0; i < ss.length; i++) {
                sss.append("");
            }
            customer.setMobile(sss.toString());
        }

    }
    private void validateLength(Customer customer){
        if(isNull(customer.getName())){
            throw new InvalidCustomerException(customer,"ten bi trong");
        }
        if(isNull(customer.getMobile())){
            throw new InvalidCustomerException(customer,"sdt bi trong");
        }

    }
    private void checkExist(Customer customer){
        if(customerStore.findAll().stream().filter(customer1 -> customer1.getMobile().equals(customer.getMobile()))
                .findFirst().isPresent()){
            throw new DuplicateCustomerException(customer,String.format("SDT da ton tai"));
        }
    }
    @Override
    public Customer updateCustomer(Customer customer) {
        validate(customer);
        findById(customer.getId());
        customerStore.insertOrUpdate(customer);
        return customer;
    }

    @Override
    public void deleteCustomerById(String id) {
        if(isNull(id)){
            throw new IllegalArgumentException("ID bi trong");
        }
        findById(id);
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {

        Collection<Customer> values = customerStore.findAll();
        List<Customer> listOfValues = new ArrayList<Customer>(values);
        List<Customer> listSort = listOfValues.stream().sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
        return listSort;
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {

        List<Customer> listOfValues = customerStore.findAll();
        List<Customer> listSort = listOfValues.stream().limit(limit).sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
        return listSort;
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, int limit) {

        List<Customer> listOfValues = customerStore.findAll();
        List<Customer> listSortByName = listOfValues.stream().filter(customer -> customer.getName().equalsIgnoreCase(custName))
                .limit(limit).sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
        return listSortByName;
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        LocalDate localDate1 = LocalDate.now();

        List<SummaryCustomerByAgeDTO> summaryCustomerByAgeDTOList = new ArrayList<>();
        List<Customer> listOfValues = customerStore.findAll();
        Map<Integer, Integer> tuoi = new HashMap<>();
        Set set = tuoi.keySet();
        for(Customer customer: listOfValues) {
            int is = tuoi.put( Period.between(customer.getBirthDay(), localDate1).getYears(),1);
                if(tuoi.containsKey(is)){
                    tuoi.put(is, tuoi.get(is) + 1);
                }
                else {
                    tuoi.put(is, 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : tuoi.entrySet()) {
            SummaryCustomerByAgeDTO temp = new SummaryCustomerByAgeDTO(entry.getKey(), entry.getValue());
            summaryCustomerByAgeDTOList.add(temp);
        }
        return summaryCustomerByAgeDTOList;
    }

}
