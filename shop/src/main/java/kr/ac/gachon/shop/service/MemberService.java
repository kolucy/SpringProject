package kr.ac.gachon.shop.service;

import kr.ac.gachon.shop.entity.Member;
import kr.ac.gachon.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional // 개발시에만 적용(rollback)
@RequiredArgsConstructor // bean 주입 방법 생성자 final member, @NonNull member 생성자 생성함
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        this.validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다."); // 예외 처리
        }
    }
}
