package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String mainPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "mainPage";
    }

    @GetMapping("/admin/{id}")
    public String adminPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "adminPage";
    }

    @GetMapping("/admin/new")
    public String newUserPage(Model model) {
        model.addAttribute("user", new User());
        return "newUserPage";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/{id}/edit")
    public String editUserPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "editUserPage";
    }

    @PatchMapping("admin/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}