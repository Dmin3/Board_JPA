package study.Board_JPA.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.Board_JPA.domain.Member;
import study.Board_JPA.repository.MemberRepository;
import study.Board_JPA.web.MemberForm;

import javax.validation.constraints.NotNull;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean login(String id, String pw) {

        Member member = memberRepository.findIdName(id);

        if (member == null){
            log.info("멤버가 없음");
            return false;
        }
        if (!member.getPassword().equals(pw)){
            log.info("비밀번호 틀림");
            return false;
        }
        return true;

    }


    @Transactional
    public void save(Member member){
        String id = member.getMemberIdName();
        log.info("id = " + id);
        //중복회원 검사
       validateDuplicateMember(id);
        memberRepository.save(member);
    }

    private void validateDuplicateMember(String id) {
        Member findName = memberRepository.findIdName(id);
        if (findName == null){
            return;
        }
        if (id.equals(findName.getMemberIdName())){
            log.info("이미 존재하는 회원");
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public Member findOne(Member member){
        return memberRepository.findById(member.getId()).get();
    }








}
