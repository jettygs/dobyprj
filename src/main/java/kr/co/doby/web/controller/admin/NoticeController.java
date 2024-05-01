package kr.co.doby.web.controller.admin;

import kr.co.doby.web.entity.Notice;
import kr.co.doby.web.entity.NoticeView;
import kr.co.doby.web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice")
public class NoticeController{

    @Autowired
    private NoticeService service;

    @GetMapping("list")
    public String list(Model model){
        List<NoticeView> list = service.getList(1, null, 1);

        model.addAttribute("list", list);

        System.out.println(list);
        return "admin/notice/list";
    }

    @GetMapping("detail")
        public String detail(
                @RequestParam(value = "id") Long id, Model model){
            NoticeView notice = service.getById(id);
            model.addAttribute("notice", notice);
        return "admin/notice/detail";
    }


    @GetMapping("reg") // reg페이지
    public String reg(){
        return "admin/notice/reg";
    }



    @GetMapping("edit")
    public String edit(
            @RequestParam(value = "id") Long id, Model model){
        System.out.println("수정하기 form 타나요???");
        model.addAttribute("notice", service.getById(id));
        System.out.println(model);
        return "/admin/notice/edit";
    }

    @PostMapping("reg")
    public String reg(@RequestParam(name = "title", required = true) String title,
                      @RequestParam(name = "content", required = true) String content){

        Notice notice = Notice.builder()
                .title(title)
                .content(content)
                .build();

        System.out.println("새로운 게시글은 : " + notice);
        service.reg(notice);

        return "redirect:/admin/notice/list";
    }
}
