package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//비율에 따른 할인율 적용 구현 객체
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
