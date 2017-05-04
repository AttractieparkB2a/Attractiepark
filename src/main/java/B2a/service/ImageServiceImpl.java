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
import java.util.ArrayList;
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

        if(file != null) {
            try {
                fileContent = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        imageForm.setImage(fileContent);

        imageRepository.save(imageForm);
    }

    @Override
    public void delete(Long id) {
        imageRepository.delete(id);
    }

    @Override
    public UserImage findOne(Long id) {
        return imageRepository.findOne(id);
    }

    @Override
    public Iterable<UserImage> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public LinkedHashMap<Long, Image> findPhotos() {
        List<Long> ids = imageRepository.findAllIdByUser_id(userService.findUser().getId());

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

    @Override
    public List<Image> findByUserId(Long id) {
        List<Long> ids = imageRepository.findAllIdByUser_id(id);
        List<Image> loadedImages = new ArrayList<>();

        for(Long i : ids)
            loadedImages.add(imageRepository.findOneById(i));

//        for(Long i : ids) {
//            images.put(i, new ProxyImage(i));
//        }
//
//        for(Image i : images.values()) {
//            Image image = images.get(i);
//            image.load();
//            loadedImages.add(image);
//        }

        return loadedImages;
    }

    @Override
    public Long findUserIdById(Long id) {
        return imageRepository.findUserIdById(id);
    }
}
