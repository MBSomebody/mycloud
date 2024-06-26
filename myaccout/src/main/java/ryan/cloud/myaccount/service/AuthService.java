package ryan.cloud.myaccount.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ryan.cloud.myaccount.dao.mapper.MyusersCusMapper;
import ryan.cloud.myaccount.dao.model.Myusers;

@Service
public class AuthService {

    @Autowired
    private MyusersCusMapper userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public Myusers findByUsername(String username) {
        return userRepository.queryByUsername(username);
     }

    public Myusers saveUser(String username, String password, String role) {
        Myusers user = new Myusers();
        user.setUsername(username);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        user.setPassword(encoder.encode(password));
        user.setRole(role);
        userRepository.insert(user);
        return user;
    }
}