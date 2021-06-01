package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextinfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            //object 타입으로 해준 이유는 빈 타입을 지정 해주지 않았기 때문에
            //object 타입선언 한다.
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = "+ beanDefinitionName + " object = "+ bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //getBeanDefinition() 빈에 대한 메타데이터 정보를 꺼낼 수 있다.
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //만약 스프링 내부에서 자동으로 등록한 빈이 아닌 내가 직접 등록한 빈을 꺼내오는 로직
            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈빈
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = "+ beanDefinitionName + " object = "+ bean);
            }
        }
    }
}
