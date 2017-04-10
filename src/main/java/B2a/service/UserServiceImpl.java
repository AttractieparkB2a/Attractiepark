package B2a.service;

import B2a.domain.Role;
import B2a.domain.User;
import B2a.repository.UserRepository;
import B2a.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        if(roleRepository.findByName("ROLE_MEMBER") == null) {
            Role member = new Role("ROLE_MEMBER");
            Role admin = new Role("ROLE_ADMIN");
            roleRepository.save(member);
            roleRepository.save(admin);

            User adminUser = new User("admin@b2a.com", "admin", "admin", "Admin", "Admin", new Date(3-1-2000), "Lovensdijkstraat", "Breda", "1111 AA", false);
            adminUser.setPassword(bCryptPasswordEncoder.encode(adminUser.getPassword()));
            adminUser.setRole(admin);
            userRepository.save(adminUser);
        }
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByName("ROLE_MEMBER"));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
