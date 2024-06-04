package ryan.cloud.bizapp.service; 
import org.springframework.stereotype.Service;

import ryan.cloud.bizapp.entity.User;
import ryan.cloud.bizapp.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
