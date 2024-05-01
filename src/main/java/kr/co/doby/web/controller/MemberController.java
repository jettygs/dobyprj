package kr.co.doby.web.controller;

import kr.co.doby.web.config.auth.DobyUserDetails;
import kr.co.doby.web.entity.Member;
import kr.co.doby.web.entity.MemberTechView;
import kr.co.doby.web.entity.Tech;
import kr.co.doby.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("index")
    public String index(){
        return "member/index";
    }

    @GetMapping("profile")
    public String profile(Model model, Authentication authentication){
        DobyUserDetails details = (DobyUserDetails) authentication.getPrincipal();
        System.out.println("현재 유저의 아이디 : " + details.getId());

        Long id = details.getId();

        Member member = service.getById(id);
        List<Tech> techList = service.getTechList();
        // 멤버 태그 + 기술 스택 MemberTechView
        List<MemberTechView> memberTechList = service.getMemberTechViewList(member.getId()); // member가 저장했던 tech의 List를 가져와

        model.addAttribute("member", member);
        model.addAttribute("techList", techList);
        model.addAttribute("memberTechList", memberTechList); // addAttribute 해 준다.

        System.out.println("현재 멤버가 가지고 있는 기술" + memberTechList);

        return "member/profile";
    }

    @GetMapping("withdraw")
    public String withdraw(){
        return "member/withdraw";
    }

}
