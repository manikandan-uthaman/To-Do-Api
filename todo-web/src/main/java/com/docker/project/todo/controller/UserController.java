package com.docker.project.todo.controller;

import com.docker.project.todo.business.dto.UserDTO;
import com.docker.project.todo.security.CurrentUser;
import com.docker.project.todo.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public UserDTO getUserDetails(@CurrentUser UserPrincipal user){
        return new UserDTO(String.valueOf(user.getId()), user.getUsername(), user.getName());
    }
}
