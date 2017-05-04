package B2a.service;

import B2a.domain.image.Image;
import B2a.domain.image.UserImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;

public interface ImageService {
    void addImage(MultipartFile file, UserImage imageForm);
    void delete(Long id);
    UserImage findOne(Long id);
    Iterable<UserImage> findAll();
    LinkedHashMap<Long, Image> findPhotos();
    Image findPhoto(Long id);

    LinkedHashMap<Long, Image> findByUserId(Long id);
}
