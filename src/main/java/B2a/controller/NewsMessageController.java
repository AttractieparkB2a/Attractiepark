package B2a.controller;

import B2a.domain.NewsMessage.NewsMessage;
import B2a.service.NewsMessageService;
import B2a.validator.NewsMessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class NewsMessageController {

    private NewsMessageService newsMessageService;
    private NewsMessageValidator newsMessageValidator;

    @Autowired
    public NewsMessageController(NewsMessageService newsMessageService, NewsMessageValidator newsMessageValidator) {
        this.newsMessageService = newsMessageService;
        this.newsMessageValidator = newsMessageValidator;
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.GET)
    public String newsmessage(Model model) {
       model.addAttribute("messageForm", new NewsMessage());

       return "newsmessage";
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.POST)
    public String newsmessage(@Valid @ModelAttribute("messageForm") NewsMessage messageForm, BindingResult bindingResult, Model model) {

        newsMessageValidator.validate(messageForm, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("messageForm", messageForm);
            return "newsmessage";
        }

       newsMessageService.findEmails(messageForm);

        return "redirect:/";
    }
}