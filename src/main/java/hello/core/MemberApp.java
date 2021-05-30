package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
        //ApplicationContext -> 스프링 컨테이너를 의미
        //AnnotationConfigApplicationContext(AppConfig.class) -> 안에 빈 등록한 클래스 파일을 파라미터 값으로 넣어줌

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        //name 값에는 설정 클래스에 등록 되어있는 메서드 이름 / 뒤에는 가져올 타입
        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember= " +findMember.getName());
        }
}
