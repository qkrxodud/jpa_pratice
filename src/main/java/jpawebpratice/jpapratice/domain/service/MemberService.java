package jpawebpratice.jpapratice.domain.service;

import jpawebpratice.jpapratice.domain.Exception.NotEnoughStockException;
import jpawebpratice.jpapratice.domain.Member;
import jpawebpratice.jpapratice.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void joinMember(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> memberList = memberRepository.findByName(member.getNickName());
        if (memberList.size() > 0 ) {
            throw new NotEnoughStockException("이미 존재하는 닉네임 입니다.");
        }
    }
}
