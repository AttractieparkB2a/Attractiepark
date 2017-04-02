package B2a.service;

import B2a.domain.User;
import B2a.domain.image.Image;
import B2a.domain.image.ProxyImage;
import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private UserService userService;
    private LinkedHashMap<Long, Image> images = new LinkedHashMap<>();

    public ImageServiceImpl(ImageRepository imageRepository, UserService userService) {
        this.imageRepository = imageRepository;
        this.userService = userService;
    }

    @Override
    public void addImage(MultipartFile file, UserImage imageForm) {
        byte[] fileContent = null;

        try {
            fileContent = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageForm.setImage(fileContent);

        imageRepository.save(imageForm);
    }

    @Override
    public LinkedHashMap<Long, Image> findPhotos() {
        List<Long> ids = imageRepository.findAllIdByUser_id(findUser().getId());

        for(Long id : ids) {
            images.put(id, new ProxyImage(id));
        }

        return images;
    }

    @Override
    public Image findPhoto(Long id) {
        Image image = images.get(id);
        Long userId = image.load();
        return imageRepository.findOneById(userId);
    }

    public User findUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByUsername(authentication.getName());
    }
}
