package B2a.repository;

import B2a.domain.User;
import B2a.domain.image.UserImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<UserImage, Long> {

    @Query("SELECT ui.name FROM UserImage ui WHERE ui.user = ?1")
    Iterable<String> findAllNameByUser(User user);

    List<UserImage> findByUser(User user);

    @Query("SELECT ui.user.id FROM UserImage ui WHERE ui.id = ?1")
    Long findUserIdById(Long id);
}
