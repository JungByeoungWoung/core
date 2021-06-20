package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
//requset 스코프로 지정
//스코프 생성으로 인해 이 MyLogger 빈은 HTTP 요청 당 하나씩 생성되고,
//HTTP 요청이 끝나는 시점에 소멸
@Scope(value = "request")
//로그를 출력하기 위한 클래스
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message){
        System.out.println("["+uuid+"]"+" ["+requestURL+"]"+message);
    }
    @PostConstruct
    public void init(){
        //초기화메서드 사용하여 uuid를 저장
        //MyLogger 빈은 http 요청 하나당 하나씩 생성 되기 때문에 요청을 uuid를 통해 구분 가능
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create"+this);
    }
    @PreDestroy
    public void destory(){
        System.out.println("["+uuid+"] request scope bean close"+this);
    }
}
