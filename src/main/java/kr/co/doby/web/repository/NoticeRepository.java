package kr.co.doby.web.repository;

import kr.co.doby.web.entity.Notice;
import kr.co.doby.web.entity.NoticeView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeRepository {

    NoticeView findById(Long id);

    List<NoticeView> findAll(Integer page, String query, String filterName);

    void save(NoticeView notice);

    NoticeView last();

    void removeById(Long id);

    void update(NoticeView notice);

    void updateHit(Long id);
}
