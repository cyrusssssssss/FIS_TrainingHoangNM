package fis.finalTest.security;




import fis.finalTest.dto.CustomerDTO;
import fis.finalTest.entity.Customer;
import fis.finalTest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerService customerService;
    @Override

    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        CustomerDTO customer = this.customerService.findCustomerById(Long.parseLong(id));

        if (customer == null) {
            System.out.println("User not found! " + id);
            throw new UsernameNotFoundException("User " + id + " was not found in the database");
        }

        System.out.println("Found User: " + customer);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = new ArrayList<>();
        roleNames.add(String.valueOf(customer.getRole()));
        System.out.println("Role: " + roleNames.get(0));
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }



        UserDetails userDetails = (UserDetails) new User(customer.getId().toString(),
                customer.getPassWord(), grantList);
        return userDetails;
    }

}
