package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    OrderService orderService = ac.getBean("orderService", OrderService.class);
//주문 생성 기능 테스트
    @Test
    void createOrder(){
        //given
        long memberId = 1L;
        Member member = new Member(memberId,"jbw2", Grade.VIP);
        //when
        memberService.join(member);

        //then
        Order order = orderService.createOrder(memberId,"item1",10000);
        //할인 금액과 실제로 할인 금액인 1000원이 맞는지 확인
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
