package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

//정액 할인 정책
@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int dicountFixAmount = 1000; //천원 할인 고정
    @Override
    //vip면 1000원 할인 적용 vip가 아닐시 할인 안한 0을 반환
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return dicountFixAmount;
        }else {
            return 0;
        }
    }
}
