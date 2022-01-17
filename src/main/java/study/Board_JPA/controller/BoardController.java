package study.Board_JPA.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import study.Board_JPA.domain.Member;
import study.Board_JPA.repository.BoardRepository;
import study.Board_JPA.repository.MemberRepository;
import study.Board_JPA.service.BoardService;
import study.Board_JPA.domain.Board;
import study.Board_JPA.web.BoardForm;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;



    @GetMapping("/home")
    public String home(Model model, HttpSession session, @PageableDefault(size = 5) Pageable pageable){

        Member member = (Member) session.getAttribute("member");

        model.addAttribute("member", member);
//        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Board> boardList = boardRepository.findAll(pageable);
        int startPage = Math.max(1, boardList.getPageable().getPageNumber() - 4) ;
        int endPage = Math.min(boardList.getTotalPages(), boardList.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boardList", boardList);
        log.info("문제 없음");


        return "home";
    }

    @GetMapping("/boardRegister")
    public String getRegister(Model model){

        model.addAttribute("board", new BoardForm());

        return "boardRegister";
    }

    @PostMapping("/boardRegister")
    public String postRegister(@Valid BoardForm form, BindingResult result, HttpSession session){

        if (result.hasErrors()){
            return "boardRegister";
        }

        Member member = (Member) session.getAttribute("member");
        Member findMember = memberRepository.findById(member.getId()).get();

        Board board = Board.builder().title(form.getTitle()).content(form.getContent()).member(findMember).build();

        boardService.save(board);

        return "redirect:/home";
    }

    @GetMapping("/board/{id}")
    public String board(Model model, @PathVariable("id") Long boardId){

        Board board = boardService.findOne(boardId).get();
        model.addAttribute("board", board);
        return "board";
    }

    @GetMapping("/board/{id}/edit")
    public String updateForm(@PathVariable("id") Long boardId, Model model){

        Board findBoard = boardService.findOne(boardId).get();

        BoardForm board = new BoardForm();
        board.setId(findBoard.getId());
        board.setTitle(findBoard.getTitle());
        board.setContent(findBoard.getContent());

        model.addAttribute("board", board);

        return "boardModify";
    }

    @PostMapping("/board/{id}/edit")
    public String update(@ModelAttribute("board") BoardForm form){
        boardService.update(form);
        return "redirect:/home";
    }

    @GetMapping("/board/{id}/delete")
    public String delete(BoardForm form){
        boardService.delete(form.getId());

        return "redirect:/home";

    }


}
