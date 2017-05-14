package B2a.service;

import B2a.domain.User;
import B2a.domain.image.Image;
import B2a.domain.image.ProxyImage;
import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private UserService userService;
    private LinkedHashMap<String, Image> images = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger(ImageServiceImpl.class.getName());

    public ImageServiceImpl(ImageRepository imageRepository, UserService userService) {
        this.imageRepository = imageRepository;
        this.userService = userService;
    }

    @Override
    public void addImage(MultipartFile file, UserImage imageForm) {
        try {
            BufferedImage bi = ImageIO.read(file.getInputStream());
            File outputfile = new File("src/main/resources/static/img/" + imageForm.getName() + ".png");
            ImageIO.write(bi, "png", outputfile);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error in writing image to directory");
        }
        imageRepository.save(imageForm);
    }

    @Override
    public void delete(Long id) {
        imageRepository.delete(id);
    }

    @Override
    public void deleteImage(Long id) {
        UserImage image = imageRepository.findOne(id);

        File file = new File("src/main/resources/static/img/" + image.getName() + ".png");

        if(file.isFile()) {
            if(file.delete())
                logger.log(Level.FINE, "Successful deleted from directory");
        }
    }

    @Override
    @Transactional
    public UserImage findOne(Long id) {
        return imageRepository.findOne(id);
    }

    @Override
    @Transactional
    public Iterable<UserImage> findAll() {
        return imageRepository.findAll();
    }

    @Override
    @Transactional
    public List<UserImage> findByUserId(Long id) {
        User user = userService.findById(id);

        return imageRepository.findByUser(user);
    }

    @Override
    public Long findUserIdById(Long id) {
        return imageRepository.findUserIdById(id);
    }

    @Override
    public LinkedHashMap<String, Image> findNamesByUser() {
        Iterable<String> fileNames = imageRepository.findAllNameByUser(userService.findUser());

        for(String file : fileNames) {
            images.put(file, new ProxyImage(file));
        }
        return images;
    }

    @Override
    public Image findPhotoByUserId(String name) {
        Image image = images.get(name);
        image.load();

        return image;
    }
}
