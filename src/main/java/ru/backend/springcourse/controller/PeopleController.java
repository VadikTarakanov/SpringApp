package ru.backend.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.backend.springcourse.model.Person;
import ru.backend.springcourse.model.dao.PeopleDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PeopleDAO peopleDao;
    @Autowired
    PeopleController(PeopleDAO peopleDao) {
        this.peopleDao = peopleDao;
    }

    @GetMapping()
    public String getAllPeople(Model model) {
        model.addAttribute("people", peopleDao.getAllPeople());
        return "people/index";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", peopleDao.getPersonById(id));
        return "people/person";
    }

    @PostMapping()
    public String createNewPerson(@ModelAttribute Person person){
        peopleDao.addPerson(person);

        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleDao.getPersonById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        peopleDao.updatePerson(person, id);
        return "redirect:/people";
    }
}
