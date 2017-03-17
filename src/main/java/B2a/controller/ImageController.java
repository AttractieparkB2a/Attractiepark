package B2a.controller;

import B2a.domain.Image.Image;
import B2a.domain.Image.ProxyImage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageController {

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String image() {

        return "image";
    }

    @RequestMapping(value="/image", method = RequestMethod.POST)
    public String image(@RequestParam String action) {

        Image image1 = new ProxyImage("src/main/java/B2a/images/1.png");
        Image image2 = new ProxyImage("src/main/java/B2a/images/2.png");
        Image image3 = new ProxyImage("src/main/java/B2a/images/3.png");

        switch(action) {
            case "1":
                image1.display();
                break;
            case "2":
                image2.display();
                break;
            case "3":
                image3.display();
                break;
        }

        return "redirect:/";
    }
}
