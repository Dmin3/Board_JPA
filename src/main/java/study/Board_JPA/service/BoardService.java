package study.Board_JPA.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.Board_JPA.domain.Board;
import study.Board_JPA.repository.BoardRepository;
import study.Board_JPA.web.BoardForm;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(Board board){
        boardRepository.save(board);
    }


    public Optional<Board> findOne(Long id){
        return boardRepository.findById(id);
    }


    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @Transactional
    public void update(BoardForm form){
        Board board = boardRepository.findById(form.getId()).get();
        board.boardUpdate(form);
    }


    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).get();
        boardRepository.delete(board);
    }
}
