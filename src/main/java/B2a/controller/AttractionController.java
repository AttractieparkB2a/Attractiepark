package B2a.controller;

import B2a.domain.attraction.Attraction;
import B2a.domain.attraction.Rollercoaster;
import B2a.service.abstractService.AttractionManagerIF;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttractionController {
    AttractionManagerIF attractionManagerIF;

    public AttractionController(AttractionManagerIF attractionManagerIF){
        this.attractionManagerIF = attractionManagerIF;
    }

    @RequestMapping(value = "attraction/attractionsList", method = RequestMethod.GET)
    public ModelAndView attractionsList(Model model) {
        Iterable<Attraction> attractions = attractionManagerIF.findAllAttractions();
        return new ModelAndView("/attraction/attractionsList", "attractions", attractions);
    }


    // INFO PAGES FOR EACH ATTRACTION
    // GET INFO PAGE WITH ID
    @RequestMapping(value = "attraction/info/{id}", method = RequestMethod.GET)
    public ModelAndView info(@PathVariable("id") Attraction attraction){
        return new ModelAndView("/attraction/info", "attraction", attraction);
    }

    // ADMIN LIST. HERE YOU CAN CHANGE THE STATE OF THE ATTRACTION.
    // GET THE PAGE WITH STATE BUTTONS
    @RequestMapping(value = "attraction/adminAttractionsList", method = RequestMethod.GET)
    public ModelAndView adminAttractionList(Model model){
        Iterable<Attraction> attractions = attractionManagerIF.findAllAttractions();
        return new ModelAndView("/attraction/adminAttractionsList", "attractions", attractions);
    }

    // POST THE ACTION ON BUTTON CLICK
    @RequestMapping(value = "attraction/adminAttractionsList", method = RequestMethod.POST)
    public String adminAttractionsList(@ModelAttribute("attraction") Attraction attraction, Model model, @RequestParam(value="action", required = true) String action){
        //System.out.println("getting attraction with id: " + attraction.getId());
        Attraction a = attractionManagerIF.findAttraction( attraction.getId() );
        System.out.println("attraction = " + attraction.getName() + " with id: " + attraction.getId());
        //System.out.println("a = " + a.getName() + " with id: " + a.getId());
        attractionManagerIF.changeState(attraction, action);
        return "redirect:/attraction/adminAttractionsList";
    }


    @RequestMapping(value = "/attraction/rollercoasterForm", method = RequestMethod.GET)
    public ModelAndView rollercoasterForm(Rollercoaster rollercoaster) {
        return new ModelAndView("attraction/rollercoasterForm", "rollercoaster", null);
    }

    @RequestMapping(value = "/attraction/rollercoasterForm", method = RequestMethod.POST)
    public String rollercoasterForm(Rollercoaster rollercoaster, BindingResult result) {
        System.out.println("testing rollercoaster Post");
        if (result.hasErrors()) {
            return "attraction/attractionsList";
        }
        attractionManagerIF.saveAttraction(rollercoaster);
        return "attraction/attractionsList";
    }



    // ATTRACTION CHOOSER. THE SELECTION OF THE ATTRACTION YOU WISH TO ADD
    // GET THE PAGE WITH OPTIONS
    @RequestMapping(value = "/attraction/attractionChooser", method = RequestMethod.GET)
    public String attractionChooser(Model model){
        return "attraction/attractionChooser";
    }

    // POST SELECTION ON BUTTON CLICK
    @RequestMapping(value = "/attraction/attractionChooser", method = RequestMethod.POST)
    public String attractionChooser(Model model, @RequestParam(value="action", required = true) String action) {
        attractionManagerIF.createNewAttraction(action);
        return "redirect:/attraction/adminAttractionsList";
    }

}
