package study.Board_JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.Board_JPA.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.memberIdName = :id")
    Member findIdName(@Param("id") String id);


}
