package seunghee.studyspring.repository;

import org.springframework.stereotype.Repository;
import seunghee.studyspring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 값을 저장하기 위함
    private static long sequence = 0L;

    public void clearStore(){
        store.clear();
    }

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //null 값을 반환할 수 있도록 Optional 로 감싸주기
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
