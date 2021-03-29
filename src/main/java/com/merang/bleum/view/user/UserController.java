package com.merang.bleum.view.user;

import com.merang.bleum.biz.user.UserDAO;
import com.merang.bleum.biz.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Slf4j
@Controller
public class UserController {
    
    /** index.html에서 ajax로 호출 **/
    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal, HttpSession session) {
        session.setAttribute("name", principal.getAttribute("name"));
        session.setAttribute("email", principal.getAttribute("email"));
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @PostMapping("/signup")
    public String signUp(UserDTO dto, UserDAO userDAO, @AuthenticationPrincipal OAuth2User principal){

        System.out.println(dto);

        String value = principal.getAttribute("email");
        System.out.println("email: " + value);
        return "main";
    }

}
