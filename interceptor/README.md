# Interceptor

### 인터셉터

- 요청 전 처리될 로직 구현

1 . HandlerInterceptor를 구현하는 Interceptor 생성
```java
@Slf4j
public class EventInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("요청 핸들러 진입 전에 실행");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("컨트롤러의 요청 처리 후 화면을 띄워주는 처리 되기 전에 실행");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("컨트롤러 처리, 화면 처리가 완료된 이후 실행");
    }
}
```

2 . 인터셉터 등록
```java
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EventInterceptor())
                // 인터셉터 적용할 패턴 지정
                .addPathPatterns("/event/**")
                // 인터셉터 제외할 패턴 지정
                .excludePathPatterns("/api/user")
        ;
    }
}
```

- 인터셉터에서는 핸들러 요청 전에 실행되며 Request, Response를 받아 처리할수 있다.
- preHandle 메소드에서는 true를 리턴하면 컨트롤러 요청으로 가게되고 false를 리턴하게 되면 다음 컨트롤러를 실행하지 않는다. 