package ru.backend.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest, Model model){
        String name = httpServletRequest.getParameter("name");
        String surname = httpServletRequest.getParameter("surname");
        String message = "name " + name + "surname " + surname;
        model.addAttribute("message", message);
        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "goodbye";
    }
}
