package study.Board_JPA.domain;

import lombok.*;
import study.Board_JPA.web.BoardForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    // 연관관계 주인이야!!
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;



    //==연관관계 메소드==//
    public void changeMember(Member member){
        this.member = member;
        member.getBoards().add(this);
    }

    //==생성 메소드==//
    @Builder
    public Board(String title, String content, Member member){
        this.title = title;
        this.content = content;
        this.member = member;
        getCreateDate();
        getUpdateDate();
    }

    //수정 메소드!!
    public void boardUpdate(BoardForm form){
        this.title = form.getTitle();
        this.content = form.getContent();
    }

}
