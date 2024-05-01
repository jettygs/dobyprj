package kr.co.doby.web.config.auth;

import kr.co.doby.web.entity.InactiveMember;
import kr.co.doby.web.entity.Member;
import kr.co.doby.web.entity.MemberRoleView;
import kr.co.doby.web.repository.InactiveMemberRepository;
import kr.co.doby.web.repository.MemberRepository;
import kr.co.doby.web.repository.MemberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DobyUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Autowired
    private InactiveMemberRepository inactiveMemberRepository;


    @Autowired
    private DobyUserDetails userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByUsername(username);

        Boolean inactiveMember = inactiveMemberRepository.findInactiveMemberById(member.getId());

        userDetails.setId(member.getId());
        userDetails.setUsername(member.getUsername());
        userDetails.setPassword(member.getPassword());
        userDetails.setNickname(member.getNickname());
        userDetails.setEnabled(!inactiveMember);

        if (inactiveMember) {
            System.out.println("정지된 회원입니다.");
        } else {
            System.out.println("로그인 성공");
        }


        List<MemberRoleView> memberRoleList = memberRoleRepository.findRoleByMemberId(member.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        String roleName = null;
        for (MemberRoleView r : memberRoleList) {
            roleName = r.getRoleName();
            authorities.add(new SimpleGrantedAuthority(roleName));
        }

        userDetails.setAuthorities(authorities);


        return userDetails;
    }
}
