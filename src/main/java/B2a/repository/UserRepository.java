package B2a.repository;

import B2a.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
    List<User> findByNewsletter(boolean newsletter);
}
