package B2a.controller;

import B2a.domain.Attraction.*;
import B2a.repository.AttractionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ferdinand on 12-3-2017.
 */
@Controller
public class AttractionController {
    private AttractionBuilder builder;
    private final AttractionRepository attractionRepository;


    public AttractionController(AttractionRepository attractionRepository){

        this.attractionRepository = attractionRepository;
    }


    @RequestMapping(value = "/attractionsList", method = RequestMethod.GET)
    public String attractionsList(Model model) {
        //model.addAttribute("userForm", new User());
        return "attractionsList";
    }

    @RequestMapping(value = "/attractionForm", method = RequestMethod.GET)
    public String attractionForm(Model model) {
        model.addAttribute("rollercoasterForm", new Rollercoaster());

        return "attractionForm";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String attractionForm(@ModelAttribute("rollercoasterForm") Rollercoaster rollercoasterForm, BindingResult bindingResult, Model model) {

        return "redirect:/welcome";
    }




//    public void buttonCreateNewAttractionPressed(String attractionType){
//        if(attractionType == "Pendulum"){
//            builder = new PendulumBuilder();
//        }
//        Attraction a = builder.buildAttraction("type");
//
//
//    }
//
//
//
//    public void testStartState(){
//
//        Attraction b = new LogFlume();
//        b.setState( new RunningState(b));
//
//    }

}
