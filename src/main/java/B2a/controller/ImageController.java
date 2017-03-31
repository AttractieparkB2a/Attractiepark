package B2a.controller;

import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import B2a.validator.ImageValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ImageController {

    private ImageRepository imageRepository;
    private ImageValidator imageValidator;

    public ImageController(ImageRepository imageRepository, ImageValidator imageValidator) {
        this.imageRepository = imageRepository;
        this.imageValidator = imageValidator;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String image(Model model) {
        model.addAttribute("imageForm", new UserImage());

        return "image";
    }

    @RequestMapping(value="/image", method = RequestMethod.POST)
    public String image(@Valid @ModelAttribute("imageForm") UserImage imageForm, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {

        imageValidator.validate(imageForm, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("imageForm", imageForm);
            return "image";
        }

        byte[] fileContent = null;

        try {
            fileContent = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageForm.setImage(fileContent);

        imageRepository.save(imageForm);

        return "redirect:/";
    }

    @RequestMapping(value = "/userPhoto", method = RequestMethod.GET)
    public ModelAndView userPhoto(Model model) {
        Iterable<UserImage> images = imageRepository.findAll();

        return new ModelAndView("userPhoto", "images", images);
    }
}
