package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class MemberServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    @Test
    void join(){
        //given -> 어떠한 값을 주고
        Member member = new Member(1L, "jbw",Grade.VIP);
        //when -> 값을 실행 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then -> 값의 결과가 이렇게 나와야한다.
        Assertions.assertEquals(findMember,member);
    }
}
