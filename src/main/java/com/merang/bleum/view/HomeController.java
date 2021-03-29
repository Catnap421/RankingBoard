package com.merang.bleum.view;

import com.merang.bleum.biz.user.UserDTO;
import com.merang.bleum.biz.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User principal, UserDTO dto){
        if(!principal.equals(null) && userService.getUser(dto).equals(null)) {
            return "redirect:signup.html";
        } else
            return "index.html";

    }

    @GetMapping("/signup")
    public String signup(){
        return "signup.html";
    }
}
