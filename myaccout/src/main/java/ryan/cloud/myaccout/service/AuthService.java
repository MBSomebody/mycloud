package ryan.cloud.myaccout.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ryan.cloud.myaccout.dao.mapper.MyusersCusMapper;
import ryan.cloud.myaccout.dao.model.Myusers;

@Service
public class AuthService {

    @Autowired
    private MyusersCusMapper userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Myusers findByUsername(String username) {
        return userRepository.queryByUsername(username);
    }

    public Myusers saveUser(String username, String password, String role) {
        Myusers user = new Myusers();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        userRepository.insert(user);
        return user;
    }
}