package hello.core.singleton;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServicTest {
    @Test
    public void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("StatefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userA = statefulService1.order("userA", 10000);
        int userB = statefulService2.order("userB", 20000);

        System.out.println("price = " + userA);

    }
    static class TestConfig{
        @Bean
        public StatefulService StatefulService(){
            return new StatefulService();
        }
    }
}
