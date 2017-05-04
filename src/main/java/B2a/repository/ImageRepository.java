package B2a.repository;

import B2a.domain.image.UserImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<UserImage, Long> {

    @Query("SELECT ui.id FROM UserImage ui WHERE ui.user.id = ?1")
    List<Long> findAllIdByUser_id(Long user_id);

    UserImage findOneById(Long id);

    @Query("SELECT ui.user.id FROM UserImage ui WHERE ui.id = ?1")
    Long findUserIdById(Long id);
}
