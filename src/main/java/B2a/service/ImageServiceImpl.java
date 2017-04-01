package B2a.service;

import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
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
}
