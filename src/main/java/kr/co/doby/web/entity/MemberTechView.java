package kr.co.doby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberTechView {
    private Long id;
    private String name;
    private String image;
    private Long parentId;
    private Long memberId;
    private Long techId;
}
