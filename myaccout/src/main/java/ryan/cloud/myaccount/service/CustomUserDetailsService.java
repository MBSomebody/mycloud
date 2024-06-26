//package ryan.cloud.myaccount.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.stereotype.Service;
//import ryan.cloud.myaccount.dao.model.Myusers;
//
//import static org.springframework.security.core.userdetails.User.withUsername;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private AuthService authService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Myusers user = authService.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        UserBuilder builder = withUsername(username);
//        builder.password(user.getPassword());
//        builder.roles(user.getRole());
//        return builder.build();
//    }
//}
