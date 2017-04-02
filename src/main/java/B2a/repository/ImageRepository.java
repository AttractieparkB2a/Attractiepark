package B2a.repository;

import B2a.domain.Image.UserImage;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<UserImage, Long> {
}
