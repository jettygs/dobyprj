package kr.co.doby.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("login")
    public String login(String returnURL) {
        System.out.println(returnURL);
        return "user/login";
    }

}
