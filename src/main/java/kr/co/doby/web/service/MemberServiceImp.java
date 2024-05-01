package kr.co.doby.web.service;

import kr.co.doby.web.entity.Member;
import kr.co.doby.web.entity.MemberTechView;
import kr.co.doby.web.entity.Tech;
import kr.co.doby.web.repository.MemberRepository;
import kr.co.doby.web.repository.MemberTechRepository;
import kr.co.doby.web.repository.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private MemberTechRepository memberTechRepository;

    @Override
    public Member getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void edit(Member member) {
        repository.update(member);
        repository.findById(member.getId());
    }

    @Override
    public List<Tech> getTechList() {
        return techRepository.findAll();
    }

    @Override
    public List<MemberTechView> getMemberTechViewList(Long id) {
        return memberTechRepository.findViewAllById(id);
    }

    @Override
    public Member updateProfileImage(Member member) {
        return null;
    }

//    @Override
//    public List<MemberTechView> getMemberTechViewList(Long id) {
//        return memberTechRepository.findViewAllById(id);
//    }


}
