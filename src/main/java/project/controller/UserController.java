package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.Services.UserServices;
import project.models.User;

@Controller
public class UserController {
 private final UserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
//
//    @GetMapping
//    public String first(Model model){
//        model.addAttribute("title", "Список пользователей: ->");
//        return "index";
//    }
    @GetMapping("/")
    public String userTable(Model model){
        model.addAttribute("user1s",userServices.listUsers());
        return "user";
    }
    @GetMapping("/users")
    public String userTable1(Model model){
        model.addAttribute("user1s",userServices.listUsers());
        return "user";
    }
//    @GetMapping("/{id}/delete")
//    public String show(@PathVariable("id") int id, Model model){
//        model.addAttribute("userDel", userServices.show(id));
//        return "user";
//    }
//    @GetMapping("/users/{id}/delete")
//    public String deleteUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("deleteUser", userServices.show(id));
//        return "user";
//    }
    @GetMapping("/users/new")
    public String newUser(Model model){
        model.addAttribute("newUser", new User());
        return "newUser";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        userServices.delete(id);
        return "redirect:/users";
    }
    @PostMapping
    public String create(@ModelAttribute("newUser") User user) {
    userServices.save(user);
    return "redirect:/users";
    }

//    @PostMapping
//    public String delete(@ModelAttribute("UserDel") int id){
//        userServices.delete(id);
//        return "redirect:/users";
//    }






}
