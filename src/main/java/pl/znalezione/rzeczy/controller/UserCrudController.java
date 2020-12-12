package pl.znalezione.rzeczy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.znalezione.rzeczy.entities.user.User;
import pl.znalezione.rzeczy.services.user.UserCrudService;

import java.util.List;

@RestController
public class UserCrudController {
    private final UserCrudService userService;

    @Autowired
    public UserCrudController(UserCrudService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
