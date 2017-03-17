package B2a.controller;

import B2a.domain.Attraction.*;
import B2a.model.AttractionsList;
import B2a.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Controller
public class AttractionController {
    private AttractionBuilder builder;

    @Autowired
    private final AttractionRepository attractionRepository;

    public AttractionController(AttractionRepository attractionRepository){
        this.attractionRepository = attractionRepository;
        createProductCatalogAndProducts();
    }

    @Transactional
    private void createProductCatalogAndProducts() {
        Attraction a = new Rollercoaster("invoernaam");
        attractionRepository.save(a);
    }

    @RequestMapping(value = "/attractionsList", method = RequestMethod.GET)
    public String attractionsList(Model model) {
        //model.addAttribute("userForm", new User());
        return "attractionsList";
    }

    @RequestMapping(value = "/attractionForm", method = RequestMethod.GET)
    public String attractionForm(Model model) {
        //model.addAttribute("rollercoasterForm", new Rollercoaster());

        return "attractionForm";
    }

    @RequestMapping(value = "/attraction/rollercoasterForm", method = RequestMethod.GET)
    public String rollercoasterForm(Model model) {
        model.addAttribute("rollercoasterForm", new Rollercoaster("emptyname"));

        return "attraction/rollercoasterForm";
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
