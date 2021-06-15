package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void LifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        LifeCycleConfig client = ac.getBean(LifeCycleConfig.class);
        ac.close();
    }
    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            //생성자 호출,의존 관계 주입
            NetworkClient networkClient = new NetworkClient();
            //의존관계 주입 후 .setUrl 실행
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
