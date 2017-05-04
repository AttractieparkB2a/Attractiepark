package B2a.controller;

import B2a.domain.User;
import B2a.domain.image.Image;
import B2a.domain.image.UserImage;
import B2a.service.ImageService;
import B2a.service.UserService;
import B2a.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class ImageController {

    private ImageService imageService;
    private UserService userService;
    private ImageValidator imageValidator;

    @Autowired
    public ImageController(ImageService imageService, UserService userService, ImageValidator imageValidator) {
        this.imageService = imageService;
        this.userService = userService;
        this.imageValidator = imageValidator;
    }

    @RequestMapping(value = "/image/index/{id}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable("id") String id) {
        model.addAttribute("id", id);
        model.addAttribute("images", imageService.findByUserId(Long.parseLong(id)));

        return "image/index";
    }

    @RequestMapping(value = "/image/create/{id}", method = RequestMethod.GET)
    public String create(Model model, @PathVariable("id") String id) {
        model.addAttribute("imageForm", new UserImage());
        model.addAttribute("users", userService.findById(Long.parseLong(id)));

        return "image/create";
    }

    @RequestMapping(value="/image/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("imageForm") UserImage imageForm, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {

        imageValidator.validate(imageForm, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("imageForm", imageForm);
            return "image/create";
        }
        imageService.addImage(file, imageForm);

        return "redirect:/image/index/" + imageForm.getUser().getId();
    }

    @RequestMapping(value = "/image/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id) {
        UserImage image = imageService.findOne(Long.parseLong(id));

        model.addAttribute("imageForm", image);
        model.addAttribute("users", userService.findById(image.getUser().getId()));

        return "image/create";
    }

    @RequestMapping(value = "/image/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        Long user_id = imageService.findUserIdById(Long.parseLong(id));
        imageService.delete(Long.parseLong(id));

        return "redirect:/image/index/" + user_id;
    }

    @RequestMapping(value = "/userPhoto", method = RequestMethod.GET)
    public ModelAndView userPhoto() {
        LinkedHashMap<Long, Image> images = imageService.findPhotos();

        return new ModelAndView("userPhoto", "images", images.values());
    }

    @RequestMapping(value = "selectedPhoto/{id}", method = RequestMethod.GET)
    public ModelAndView selectedPhoto(@PathVariable("id") String id) {
        Image userImage = imageService.findPhoto(Long.parseLong(id));

        return new ModelAndView("selectedPhoto", "images", userImage);
    }
}
