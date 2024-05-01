package kr.co.doby.web.controller.api;

import kr.co.doby.web.entity.Member;
import kr.co.doby.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("apiUserController")
@RequestMapping("/api/members")
public class UserController {

    @Autowired
    public MemberService service;

}
