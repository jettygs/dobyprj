package kr.co.doby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRoleView {
    private Long member_id; // 회원 id
    private Long roleId;
    private String roleName;

}
