package kr.co.doby.web.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.doby.web.entity.Member;
import kr.co.doby.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import retrofit2.http.Multipart;

@RestController("apiMemberController")
@RequestMapping("api/members")
public class MemberController {

    @Autowired
    MemberService service;

    @PutMapping
    public ResponseEntity edit(
            @RequestBody Member member){
        service.edit(member);

        System.out.println("요청들어왓나요?");
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public Member editProfileImage(
            HttpServletRequest request,
            Member member, MultipartFile imgFile
    ){

        member.setProfileImage(imgFile.getOriginalFilename());
        member.setId(member.getId());

        Member profileImage = service.updateProfileImage(member);

        return profileImage;
    }

}
