package study.Board_JPA.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import study.Board_JPA.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
