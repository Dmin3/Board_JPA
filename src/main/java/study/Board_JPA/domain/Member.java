package study.Board_JPA.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String memberIdName;

    private String memberName;

    private int age;

    private String password;

    private String sex;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Board> boards = new ArrayList<>();


    @Builder
    public Member(String memberIdName, String memberName, int age, String sex, String password){
        this.memberIdName = memberIdName;
        this.memberName = memberName;
        this.age = age;
        this.sex = sex;
        this.password = password;
    }

}
