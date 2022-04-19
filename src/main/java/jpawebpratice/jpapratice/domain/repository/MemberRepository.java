package jpawebpratice.jpapratice.domain.repository;

import jpawebpratice.jpapratice.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    // 회원 저장
    public void save(Member member){
        em.persist(member);
    }

    // 회원클래스 단일 조회
    public Member findMember(Member member) {
        return em.find(Member.class, member);
    }

    // 회원 전체 조회
    public List<Member> memberList() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }

    // 회원아이디 단일 조회
    public Member findOne(Long memberId) {
        return em.find(Member.class, memberId);
    }

    // 회원 이름으로 찾기
    public List<Member> findByName(String nickName) {
        return  em.createQuery("Select m from Member m where m.nickName = :nickName")
                .setParameter("nickName", nickName)
                .getResultList();
    }
}
