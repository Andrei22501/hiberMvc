package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.models.User;
import project.services.UserServices;

@Controller
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/")
    public String userTable(Model model) {
        model.addAttribute("user1s", userServices.listUsers());
        return "user";
    }

    @GetMapping("/users")
    public String userTable1(Model model) {
        model.addAttribute("user1s", userServices.listUsers());
        return "user";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.show(id));
        return "editTable";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userServices.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServices.update(id, user);
        return "redirect:/users";
    }

    @PostMapping
    public String create(@ModelAttribute("newUser") User user) {
        userServices.save(user);
        return "redirect:/users";
    }


}
