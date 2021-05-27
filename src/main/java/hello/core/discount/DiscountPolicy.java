package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    //Member member -> Member 파라미터를 넘기고 있는 것을 의미
    int discount(Member member, int price);
}
