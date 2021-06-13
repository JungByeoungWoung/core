package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    //private MemberRepository memberRepository= new MemoryMemberRepository();
    //private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
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
