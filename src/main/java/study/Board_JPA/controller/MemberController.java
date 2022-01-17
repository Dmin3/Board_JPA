package study.Board_JPA.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.Board_JPA.domain.Member;
import study.Board_JPA.repository.MemberRepository;
import study.Board_JPA.service.MemberService;
import study.Board_JPA.web.MemberForm;


import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String JoinForm(Model model){

        model.addAttribute("member", new MemberForm());


        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute("member") MemberForm form){

        Member member = Member.builder()
                        .memberIdName(form.getMemberIdName())
                        .memberName(form.getMemberName())
                        .age(form.getAge())
                        .sex(form.getSex())
                        .password(form.getPassword())
                        .build();

        memberService.save(member);


        return "redirect:/home";
    }

    @GetMapping("/login")
    public String loginForm(Model model){

        model.addAttribute("loginInfo", new MemberForm());

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginInfo") MemberForm info, HttpSession session){

        String id = info.getMemberIdName();
        String pw = info.getPassword();
       if (memberService.login(id, pw)){
           Member member = memberRepository.findIdName(id);
           session.setAttribute("member", member);
           return "home";
        }


        return "login";
    }






}
