package com.merang.bleum.view;

import com.merang.bleum.biz.user.UserDTO;
import com.merang.bleum.biz.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller("/")
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User principal, UserDTO dto){
        if(principal == null) return "index.html";
        else {
            String email = principal.getAttribute("email");
            dto.setEmail(email);
            if(!userService.existUser(dto)) return "signup.html";
            return "index.html";
        }
    }

    @GetMapping("/home")
    public String home(){
        return "home.html";
    }


}
