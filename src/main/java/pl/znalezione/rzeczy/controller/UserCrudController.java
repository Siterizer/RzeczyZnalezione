package pl.znalezione.rzeczy.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserCrudController {


    @GetMapping("/users")
    public String getAllUsers() {
        return "Hello world";
    }

}
