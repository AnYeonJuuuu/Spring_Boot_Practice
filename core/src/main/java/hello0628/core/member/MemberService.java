package hello0628.core.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
