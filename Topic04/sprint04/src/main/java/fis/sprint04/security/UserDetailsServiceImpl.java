package fis.sprint04.security;



import fis.sprint04.dto.DetectiveDTO;
import fis.sprint04.service.DetectiveService;
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
    private DetectiveService detectiveService;
    @Override

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        DetectiveDTO detective = this.detectiveService.findByUserName(userName);

        if (detective == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + detective);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = new ArrayList<>();
        roleNames.add(String.valueOf(detective.getRank()));
        System.out.println("Role: " + roleNames.get(0));
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        System.out.println("Role: " + grantList.get(0));
        List<GrantedAuthority> grantList1 = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("INSPECTOR");
        grantList1.add(authority);
//        UserDetails userDetails = (UserDetails) new User("huhu",
//                "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu", grantList1);
        UserDetails userDetails = (UserDetails) new User(detective.getUserName(),
                detective.getPassWord(), grantList);
        return userDetails;
    }

}
