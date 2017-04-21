package eu.nyerel.searchtable.example.controller;

import eu.nyerel.searchtable.example.core.service.PersonService;
import eu.nyerel.searchtable.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
@RestController
@RequestMapping("/rest/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") long id) {
        return personService.getPerson(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Person> getPeople(@RequestParam("page") int page, @RequestParam("size") int size) {
        return personService.getAllPeople(new PageRequest(page, size));
    }

}
