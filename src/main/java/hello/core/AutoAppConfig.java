package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component 라는 어노테이션을 붙은 클래스들을 스프링으로 등록 해줌
@ComponentScan(
        //컴포넌트 스캔으로 스프링 빈을 등록해주는데 그중에서
        //뺄 것들을 등록해주는 역할
        //Appconfig가 Configuration 어노테이션이 붙어있기 때문에 충돌 방지로 빼게 해줌
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
