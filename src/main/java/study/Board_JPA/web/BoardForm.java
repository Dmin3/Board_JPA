package study.Board_JPA.web;

import lombok.Getter;
import lombok.Setter;
import study.Board_JPA.domain.Member;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BoardForm {

    private Long id;

    @NotEmpty(message = "제목은 필수입니다.")
    private String title;

    private String content;

}
