package kr.co.doby.web.controller.api;

import kr.co.doby.web.config.auth.DobyUserDetails;
import kr.co.doby.web.entity.Notice;
import kr.co.doby.web.entity.NoticeView;
import kr.co.doby.web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("apiNoticeController")
@RequestMapping("api/notices")
public class NoticeController {

    @Autowired
    private NoticeService service;

    // 조건에 따라 검색하기
    @GetMapping
    public List<NoticeView> list(
            @RequestParam(name="p", defaultValue = "1")Integer page,
            @RequestParam(name="q", required = false)String query,
            @RequestParam(name="f", defaultValue = "1")Integer filterId) {
        System.out.println("---------------------");
        System.out.println(query.equals(""));
        return service.getList(page, query, filterId);
    }
    
    @GetMapping("{id}")
    public NoticeView detail(
            @PathVariable Long id
    ){
        NoticeView notice = service.getById(id);
        return notice;
    }

    // 공지사항 등록하기
    @PostMapping
    public ResponseEntity<NoticeView> reg(@RequestBody NoticeView notice, Authentication authentication){
        DobyUserDetails details = (DobyUserDetails) authentication.getPrincipal();
        System.out.println(details);
        System.out.println("현재로그인된 유저 아이디는:");
        System.out.println(details.getId());
        Long id = details.getId();
        notice.setMemberId(id);

        NoticeView newNotice = service.reg(notice);

        System.out.println("등록한 사람 아이디 : " + id);
        System.out.println("새로운 공지 : " + newNotice);

        ResponseEntity<NoticeView> response = new ResponseEntity<>(newNotice, HttpStatus.CREATED);

        return response;
    }

    // 공지사항 수정하기
    @PutMapping("{id}")
    public void edit(@PathVariable Long id,
                    @RequestBody NoticeView notice){
        System.out.println("공지사항 수정 타나요");
        service.edit(id, notice);
    }

    // 공지사항 삭제하기
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }



}
