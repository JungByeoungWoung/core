package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
//기획을 담당
//애플리케이션 전체를 설정하고 구성하는 클래스
public class AppConfig {

    //MemberService memberService = new MemberServiceImpl();
    //MemberServiceImpl 구현 객체에서 생성자를 생성했는데 그 생성자를 이용해서
    //원하는 구현 객체를 선택 할 수 있음
    //new MemoryMemberRepository() -> 래퍼런스라고 하는듯
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    private DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
