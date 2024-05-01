package kr.co.doby.web.repository;

import kr.co.doby.web.entity.MemberTechView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberTechRepository {
    List<MemberTechView> findViewAllById(Long id);
}
