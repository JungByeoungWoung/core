package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류 발생")
    public void findBeanByTypeDuplicate(){
        //MemberRepository bean -> MemberRepository 타입으로 저장하겠다는 의미
        MemberRepository bean = ac.getBean(MemberRepository.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                                        () -> ac.getBean(MemberRepository.class));
    }
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    public void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        //memberRepository 에 저장한 값과 실제 MemberRepository.class가 같은지 비교
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    public void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = "+ key +"value = "+beansOfType.get(key));
        }
        System.out.println("beansOfType " + beansOfType);
        //assertThat(beansOfType.size()).isEqualTo(2);
    }
    @Configuration
    //static을 class 앞에 선언 하면 해당 클래스 파일 안에서만 static을 선언해준 클래스를 이용하겠다는 의미
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

//        @Bean
//        public MemberRepository memberRepository2() {
//            return new MemoryMemberRepository();
//        }
    }
}
