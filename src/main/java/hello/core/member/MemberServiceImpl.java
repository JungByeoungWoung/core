package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //회원 가입을 하고 조회를 하기 위해서는 MemberRepository를 가져와야한다.
    //다만 MemberRepository는 인터페이스이기 때문에 그냥 쓰면 null exception이 일어난다.
    //따라서 구현 객체인 MemoryMemberRepository를 생성해줘야한다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
