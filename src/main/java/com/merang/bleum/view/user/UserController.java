package com.merang.bleum.view.user;

import com.merang.bleum.biz.user.UserDAO;
import com.merang.bleum.biz.user.UserDTO;
import com.merang.bleum.biz.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /** index.html에서 ajax로 호출 **/
    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal, HttpSession session) {
        session.setAttribute("name", principal.getAttribute("name"));
        session.setAttribute("email", principal.getAttribute("email"));
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @PostMapping("/signup")
    public String signup(@AuthenticationPrincipal OAuth2User principal, UserDTO dto){
        String email = principal.getAttribute("email");
        dto.setId((long) Objects.hash(email));
        dto.setEmail(email);
        log.info(dto.toString());
        userService.insertUser(dto);
        return "redirect:/";
    }

}
