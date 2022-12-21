package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping()
public class UserController {

    @RequestMapping("/users")
    public String userTable(Model model){
        model.addAttribute("user1", "Всем привет сладкие");
        return "user";
    }

}
