package com.bloom.controller;

import com.bloom.dto.user.RegisterUserDto;
import com.bloom.exception.UserAlreadyExistsException;
import com.bloom.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String displayRegisterForm(Model model) {
        model.addAttribute("user", new RegisterUserDto());
        return "/sisu/sign-up";
    }

    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute("user") @Valid RegisterUserDto user) {
        try {
            userService.registerNewUser(user);
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/login";
    }



}
