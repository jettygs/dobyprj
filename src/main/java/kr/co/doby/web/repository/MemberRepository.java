package kr.co.doby.web.repository;

import kr.co.doby.web.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberRepository {

    Member findByUsername(String username);

    Member findById(Long id);

    void update(Member member);
}
