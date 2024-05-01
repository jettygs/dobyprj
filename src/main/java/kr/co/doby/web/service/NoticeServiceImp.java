package kr.co.doby.web.service;

import kr.co.doby.web.entity.Notice;
import kr.co.doby.web.entity.NoticeView;
import kr.co.doby.web.etc.TimeDifference;
import kr.co.doby.web.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImp implements NoticeService {

    @Autowired
    NoticeRepository repository;

    @Override
    public NoticeView getById(Long id) {
        repository.updateHit(id);
        return repository.findById(id);
    }

    @Override
    public List<NoticeView> getList(Integer page, String query, Integer filterId) {

        if ("".equals(query))
            query = null;

        String filterName = null;
        if (filterId == 1)
            filterName = "id";
        else if (filterId == 2)
            filterName = "hit";

        List<NoticeView> list = repository.findAll(1, query, filterName);

        for (NoticeView notice : list) {
            Date date = notice.getRegDate();
            String timeDif = TimeDifference.getTimeDifference(date);
            notice.setTimeDifference(timeDif);
        }
        return list;
    }

    @Override
    public NoticeView reg(NoticeView notice) {
        repository.save(notice);
        NoticeView newNotice = repository.last();

        System.out.println("새로운 공지 : " + newNotice);
        return newNotice;
    }

    @Override
    public void delete(Long id) {
        repository.removeById(id);
    }

    @Override
    public void edit(Long id, NoticeView notice) {

        NoticeView currentOne = repository.findById(id);
        if (currentOne != null) {
            currentOne.setTitle(notice.getTitle());
            currentOne.setContent(notice.getContent());
            repository.update(currentOne);
        }
    }
}
