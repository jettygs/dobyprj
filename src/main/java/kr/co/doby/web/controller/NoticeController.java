package kr.co.doby.web.controller;

import kr.co.doby.web.entity.Notice;
import kr.co.doby.web.entity.NoticeView;
import kr.co.doby.web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService service;

    @GetMapping("list")
    public String list(Model model){
        List<NoticeView> list = service.getList(1, null, 1);

        model.addAttribute("list", list);

        System.out.println(list);
        return "notice/list";
    }

    @GetMapping("detail")
    public String detail(
            @RequestParam(value = "id") Long id, Model model){
        NoticeView notice = service.getById(id);
        model.addAttribute("notice", notice);
        return "notice/detail";
    }

}
