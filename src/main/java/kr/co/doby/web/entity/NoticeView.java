package kr.co.doby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeView {
    private Long id;
    private String title;
    private String content;
    private Integer hit;
    private Boolean pin;
    private Date regDate;
    private Boolean del;
    private Long memberId;

    private String nickname;
    private String timeDifference;
}
