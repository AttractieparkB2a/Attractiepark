package B2a.service;

import B2a.domain.image.UserImage;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void addImage(MultipartFile file, UserImage imageForm);
}
