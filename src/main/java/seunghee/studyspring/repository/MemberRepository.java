package seunghee.studyspring.repository;

import seunghee.studyspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //만약에 값이 null 이라면 -> null 을 반환하기 위해 Optional 사용
    Optional<Member> findByname(String name);
    List<Member> findAll();
}
