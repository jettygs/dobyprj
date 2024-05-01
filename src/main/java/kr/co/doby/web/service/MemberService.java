package kr.co.doby.web.service;

import kr.co.doby.web.entity.Member;
import kr.co.doby.web.entity.MemberTechView;
import kr.co.doby.web.entity.Tech;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    Member getById(Long id);

    void edit(Member member);

    List<Tech> getTechList();

    List<MemberTechView> getMemberTechViewList(Long id);

    Member updateProfileImage(Member member);

//    List<MemberTechView> getMemberTechViewList(Long id);
}
