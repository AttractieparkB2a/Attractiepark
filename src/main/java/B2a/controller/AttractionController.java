package B2a.controller;

import B2a.domain.Attraction.*;
import B2a.repository.AttractionRepository;
import B2a.service.abstractService.AttractionManagerIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
//
//    @RequestMapping(value = "/attraction/attractionAdmin", method = RequestMethod.GET)
//    public ModelAndView attractionAdmin(Attraction attraction) {
//
//        return new ModelAndView("attractionAdmin", "Attraction", null);
//    }


//    @RequestMapping(value = "attraction/attractionForm", method = RequestMethod.GET)
//    public String attractionForm(Model model) {
//        //model.addAttribute("rollercoasterForm", new Rollercoaster());
//
//        return "attraction/attractionForm";
//    }
//
//    @RequestMapping(value = "/attraction/rollercoasterForm", method = RequestMethod.GET)
//    public ModelAndView rollercoasterForm(Attraction attraction) {
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
        switch (action) {
            case "rollercoaster":
                //createAttraction(action);
                builder = new RollercoasterBuilder();
                System.out.println("Rollercoaster chosen");
                return "attraction/rollercoasterForm";
            case "pendulum":
                //createAttraction(action);
                builder = new PendulumBuilder();
                System.out.println("Pendulum chosen");
                return "attraction/pendulumForm";
            default:
                return "attraction/attractionChooser";

        }
    }

    public Attraction createAttractionTest(String type){
        return attractionManagerIF.createNewAttraction(type);
    }


    @RequestMapping(value = "/attraction/createAttraction", method = RequestMethod.POST)
    public Attraction createAttraction(Model model){
        String name = "hardcoded";
        int duration = 1;
        System.out.println("fucking rollercoaster");
        Attraction attraction = builder.createNewAttraction(name, duration);
        return attraction;
    }


    private void createNewRollercoaster(Rollercoaster rollercoaster) {

    }


//    public void buttonCreateNewAttractionPressed(String attractionType){
//        if(attractionType == "Pendulum"){
//            builder = new PendulumBuilder();
//        }
//        Attraction a = builder.buildAttraction("type");
//    }
//
//    public void testStartState(){
//
//        Attraction b = new LogFlume();
//        b.setState( new RunningState(b));
//
//    }
}
