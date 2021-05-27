package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //OrderServiceImpl은 추상 인터페이스인 DiscountPolicy에도 의존 하고 있으며,
    //추가로 new FixDiscountPolicy()를 보면 알수 있듯이 구현 객체인 FixDiscountPolicy도 의존하고 있다.
    //private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //아래와 같이 코드를 변경하면 인테페이스에만 의존할 수 있게 변경 가능하다.
    //MemberRepository 참조 하는 것을 알 수 있다.
    //memberRepository는 참조 값이다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //OrderServiceImpl은 MemberRepository와 DiscountPolicy에만 의존 하는 것을 알 수 있다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원을 찾는 코드
        Member member = memberRepository.findById(memberId);
        //회원 등급에 맞는 할인 가격 적용 1000원 할인 or 할인 없음
        //할인 정책에 회원정보와 아이템 가격을 넘겨줌
        int discountPrice =  discountPolicy.discount(member,itemPrice);
        //order에 맞게 반환
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
