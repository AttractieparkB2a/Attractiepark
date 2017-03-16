package B2a.service;

import B2a.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
