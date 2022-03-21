package ru.mycomp.preproj231.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mycomp.preproj231.dao.UserDao;

@Controller
public class UserController {


    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           @RequestParam(name = "surname", required = false, defaultValue = "World") String surname,
                           Model model) {
        model.addAttribute("message", "Hello, " + name + "" + surname);
        return "hello";
    }

    @GetMapping()
    public String index(Model model) {
        //Получаем из DAO, передаем в отображение в представление
        return null;
    }

    @GetMapping("/{id}")
    public String show((PathVariable("id"))
    int id, Model model){
        //Получаем из DAO, передаем в отображение в представление
        return null;
    }

}