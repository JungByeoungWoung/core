package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl();
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        //테스트를 실행 하기 전에 아래 해당 appconfig 객체 생성을 해주고 memberService 실행
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
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
