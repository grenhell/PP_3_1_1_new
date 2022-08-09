package com.example.pp_3_1_1_new.controller;

import com.example.pp_3_1_1_new.model.User;
import com.example.pp_3_1_1_new.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll (Model model){
        List <User> userList = userService.findAll();
        model.addAttribute("userlist", userList);
        return "users";

    }
    @GetMapping("/users/create")
    public String createUserForm (User user){
        return "create";
    }

    @PostMapping("/users/create")
    public String createUser (User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String read(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "/read";
    }

    @GetMapping("/users/{id}/edit")
    public String edit (Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "/edit";
    }

    @PostMapping("/users/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
