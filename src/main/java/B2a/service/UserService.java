package B2a.service;

import B2a.domain.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    List<User> findAll();

    User findById(Long id);
    User findUser();
    void switchRole(Long id);
}
