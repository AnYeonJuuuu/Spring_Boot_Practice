package hello0628.core.member;

public interface MemberRepository {

    //
    void save(Member member);

    //회원아이디로 회원 찾는 기능
    Member findById(Long memberId);

}
