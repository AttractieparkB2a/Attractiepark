package B2a.controller;

import B2a.domain.Attraction.*;
import B2a.repository.AttractionRepository;
import B2a.service.abstractService.AttractionManagerIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
public class AttractionController {
    AttractionManagerIF attractionManagerIF;

    public AttractionController(AttractionManagerIF attractionManagerIF){
        this.attractionManagerIF = attractionManagerIF;
    }

    @RequestMapping(value = "attraction/attractionsList", method = RequestMethod.GET)
    public String attractionsList(Model model) {
        return "/attraction/attractionsList";
    }

    @RequestMapping(value = "/attraction/attractionAdmin", method = RequestMethod.GET)
    public ModelAndView attractionAdmin(Attraction attraction) {

        return new ModelAndView("attractionAdmin", "Attraction", null);
    }


    @RequestMapping(value = "attraction/attractionForm", method = RequestMethod.GET)
    public String attractionForm(Model model) {
        //model.addAttribute("rollercoasterForm", new Rollercoaster());

        return "attraction/attractionForm";
    }

    @RequestMapping(value = "/attraction/rollercoasterForm", method = RequestMethod.GET)
    public String rollercoasterForm(Model model) {
        model.addAttribute("/attraction/rollercoasterForm", new Rollercoaster("emptyname"));

        return "attraction/rollercoasterForm";
    }



    @RequestMapping(value = "/attraction/attractionChooser", method = RequestMethod.GET)
    public String attractionChooser(){
        return "attraction/attractionChooser";
    }

    @RequestMapping(value = "/attraction/attractionChooser", method = RequestMethod.POST)
    public String attractionChooser(Model model, @RequestParam(value="action", required = true) String action) {
        switch (action) {
            case "rollercoaster":
                createAttraction(action);
                return "attraction/rollercoasterForm";
            case "pendulum":
                createAttraction(action);
                return "attraction/pendulumForm";
            default:
                return "attraction/attractionChooser";

        }
    }

    public Attraction createAttraction(String type){
        return attractionManagerIF.createNewAttraction(type);
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
