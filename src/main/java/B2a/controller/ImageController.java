package B2a.controller;

import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import B2a.service.ImageService;
import B2a.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class ImageController {

    private ImageService imageService;
    private ImageRepository imageRepository;
    private ImageValidator imageValidator;

    @Autowired
    public ImageController(ImageService imageService, ImageRepository imageRepository, ImageValidator imageValidator) {
        this.imageService = imageService;
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

        imageService.addImage(file, imageForm);

        return "redirect:/";
    }

    @RequestMapping(value = "/userPhoto", method = RequestMethod.GET)
    public ModelAndView userPhoto() {
        Iterable<UserImage> images = imageRepository.findAll();

        return new ModelAndView("userPhoto", "images", images);
    }
}
