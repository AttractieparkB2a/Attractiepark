package B2a.controller;

import B2a.domain.Attraction.*;
import B2a.repository.AttractionRepository;
import B2a.service.abstractService.AttractionManagerIF;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttractionController {
    AttractionManagerIF attractionManagerIF;
    AttractionRepository attractionRepository;
    AttractionBuilder builder;

    public AttractionController(AttractionManagerIF attractionManagerIF, AttractionRepository attractionRepository){
        this.attractionManagerIF = attractionManagerIF;
        this.attractionRepository = attractionRepository;
    }

    @RequestMapping(value = "attraction/attractionsList", method = RequestMethod.GET)
    public ModelAndView attractionsList(Model model) {
        Iterable<Attraction> attractions = attractionManagerIF.findAllAttractions();

        return new ModelAndView("/attraction/attractionsList", "attractions", attractions);
    }

    @GetMapping("{id}")
    public ModelAndView info(@PathVariable("id") Attraction attraction){
        return new ModelAndView("/attraction/info", "attraction", attraction);
    }

    @RequestMapping(value = "attraction/adminAttractionsList", method = RequestMethod.GET)
    public ModelAndView adminAttractionList(Model model){
        Iterable<Attraction> attractions = attractionManagerIF.findAllAttractions();
        return new ModelAndView("/attraction/adminAttractionsList", "attractions", attractions);
    }
//
//    @RequestMapping(value = "/attraction/attractionAdmin", method = RequestMethod.GET)
//    public ModelAndView attractionAdmin(attraction attraction) {
//
//        return new ModelAndView("attractionAdmin", "attraction", null);
//    }


//    @RequestMapping(value = "attraction/attractionForm", method = RequestMethod.GET)
//    public String attractionForm(Model model) {
//        //model.addAttribute("rollercoasterForm", new Rollercoaster());
//
//        return "attraction/attractionForm";
//    }
//
//    @RequestMapping(value = "/attraction/rollercoasterForm", method = RequestMethod.GET)
//    public ModelAndView rollercoasterForm(attraction attraction) {
//        return new ModelAndView("attraction/rollercoasterForm", "attraction", attraction);
//    }


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



    @RequestMapping(value = "/attraction/attractionChooser", method = RequestMethod.GET)
    public String attractionChooser(){
        return "attraction/attractionChooser";
    }

    @RequestMapping(value = "/attraction/attractionChooser", method = RequestMethod.POST)
    public String attractionChooser(Model model, @RequestParam(value="action", required = true) String action) {
        System.out.println("actie = " + action);
        attractionManagerIF.createNewAttraction(action);

        return "redirect:/attraction/attractionsList";
    }


//    @RequestMapping(value = "/attraction/createAttraction", method = RequestMethod.POST)
//    public Attraction createAttraction(Model model){
//        String name = "hardcoded";
//        int duration = 1;
//        System.out.println("fucking rollercoaster");
//        Attraction attraction = builder.createNewAttraction();
//        return attraction;
//    }


//    public void buttonCreateNewAttractionPressed(String attractionType){
//        if(attractionType == "Pendulum"){
//            builder = new PendulumBuilder();
//        }
//        attraction a = builder.buildAttraction("type");
//    }
//
//    public void testStartState(){
//
//        attraction b = new LogFlume();
//        b.setState( new RunningState(b));
//
//    }
}
