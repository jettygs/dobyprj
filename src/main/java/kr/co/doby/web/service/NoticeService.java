package kr.co.doby.web.service;

import kr.co.doby.web.entity.Notice;
import kr.co.doby.web.entity.NoticeView;

import java.util.List;

public interface NoticeService {
//    List<Notice> getList();


    NoticeView getById(Long id);

    List<NoticeView> getList(Integer page, String query, Integer filterId);

    NoticeView reg(NoticeView notice);

    void delete(Long id);

    void edit(Long id, NoticeView notice);
}
