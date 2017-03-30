package B2a.controller;

import B2a.domain.image.Image;
import B2a.domain.image.ProxyImage;
import B2a.domain.image.UserImage;
import B2a.domain.newsMessage.NewsMessage;
import B2a.repository.ImageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageController {

    ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String image(Model model) {
        model.addAttribute("imageForm", new UserImage());

        return "image";
    }

    @RequestMapping(value="/image", method = RequestMethod.POST)
    public String image(@RequestParam("file") MultipartFile file, UserImage imageForm, BindingResult result) {

        if (file.isEmpty()) {
            return "redirect:/";
        }

        byte[] fileContent = null;

        try {
            fileContent = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageForm.setImage(fileContent);

        if (result.hasErrors()) {
            return "image";
        }
        imageRepository.save(imageForm);

        return "redirect:/";
    }

    @RequestMapping(value = "/userPhoto", method = RequestMethod.GET)
    public ModelAndView userPhoto(Model model) {
        Iterable<UserImage> images = imageRepository.findAll();

        return new ModelAndView("userPhoto", "images", images);
    }
}
