package B2a.controller;

import B2a.domain.Attraction.Attraction;
import B2a.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attractions")
public class AttractionRestController {

    @Autowired
    private AttractionRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Attraction> getAll() {
        return repository.findAll();
    }
}