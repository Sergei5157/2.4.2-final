package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    static User user1 = new User("Tom", (byte) 1, 1000);
    User user2 = new User("Nick", (byte) 2, 2000);
    User user3 = new User("Robert", (byte) 3, 3000);


    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("2.3.1");
        messages.add("CRUD application");
        model.addAttribute("messages", messages);
        return "index";
    }
    @GetMapping(value = "users")
    public String allUsers(Model model){
        List <User> users = userService.getAll();
        model.addAttribute("user", users);
        return "users";
    }

    @GetMapping(value = "user/{id}")
    public String infoUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getOne(id));
        return "user";
    }
    @GetMapping(value = "new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }
   @PostMapping(value = "newuser")
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }


    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") long id){
        userService.remove(id);
        return "redirect:/users";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userService.getOne(id));
        return "/edit";
    }
    @PatchMapping(value = "update/{id}")
    public String update(@ModelAttribute ("user") User user , @PathVariable ("id") long id){
        userService.update(id, user);
        return "redirect:/users";
    }


}

