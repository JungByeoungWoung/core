package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    //ObjectProvider<MyLogger> 타입으로 생성하면 고객 요청이 들어오기 전까지
    //MyLogger 빈의 생성을 지연시킬 수 있다.
    //지연을 안시키고 그냥 실행 시키면 request가 없어서 스프링 컨테이너에 MyLogger빈이
    //없다고 오류가 생긴다.
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody //화면에서 뷰없이 문자열 정도만 출력해줄 수 있게 해주는 어노테이션
    //HttpServletRequest -> 자바에서 제공하는 http표준인데 http request에 대한 정보를 받을 수
    //있음
    public String logDemo(HttpServletRequest request){
        //.getRequestURI()을 이용해 고객이 어떤 url로 요청을 했는지 알 수있게함
        String requestURL = request.getRequestURL().toString();
        //출력 할때 ][http://localhost:8080/log-demo] controller test 식의
        //url 정보를 남겨주기 위해 .setRequestURL(requestURL)을 함
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
