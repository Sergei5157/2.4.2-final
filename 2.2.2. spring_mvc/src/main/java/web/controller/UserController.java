package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {


    @Autowired
    private static UserService userService;

    public static void main(String[] args) {
        Set<Role> role = new HashSet<>();
        role.add(new Role(1,"ROLE_USER"));
        User user = new User("user", (byte) 2, 3, "user");
        Set<Role> roles = new HashSet<>();
        role.add(new Role(1,"ROLE_USER"));
        role.add(new Role(2,"ROLE_ADMIN"));
        User admin = new User("admin", (byte) 2, 3, "admin");
        userService.add(user);
        userService.add(admin);

    }

    //User user = new User("user", 2, 3, "user", role);

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome1(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


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

