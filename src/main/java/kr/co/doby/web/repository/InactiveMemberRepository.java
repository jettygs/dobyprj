package kr.co.doby.web.repository;

import kr.co.doby.web.entity.InactiveMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InactiveMemberRepository {
    Boolean findInactiveMemberById(Long id);
}
