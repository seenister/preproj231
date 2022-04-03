package ru.mycomp.preproj231.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mycomp.preproj231.model.User;
import ru.mycomp.preproj231.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public String indexUser(Model model) {
        //Получаем из DAO, передаем в отображение в представление
        model.addAttribute("users", userService.getAllUsers());
        return "users/indexForUser";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String index(Model model) {
        //Получаем из DAO, передаем в отображение в представление
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String show(@PathVariable("id") int id, Model model) {
        //Получаем из DAO, передаем в отображение в представление
        model.addAttribute("user", userService.show(id));
        return "users/show";
    }

    @GetMapping("/admin/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String newPerson(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping("/admin/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userService.save(user);
        return "redirect:/users/admin";
    }

    @GetMapping("/admin/{id}/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "users/edit";
    }

    @PostMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "users/edit";

        userService.update(id, user);
        return "redirect:/users/admin";
    }

    @PostMapping("/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable("id") int id) {
        System.out.println(id);
        userService.delete(id);
        return "redirect:/users/admin";
    }
}