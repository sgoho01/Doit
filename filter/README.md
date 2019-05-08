# Filter

### 필터 적용
필터를 생성하여 적용하기

1 . Filter 클래스를 구현할 커스텀 필터 생성
```java
@Slf4j
public class EventFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("Init Filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        log.debug("request url : {} ", httpServletRequest.getRequestURL());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.debug("Destroy Filter");
    }
}
``` 
 
2 . 필터 등록 
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public FilterRegistrationBean getFilterRegistrationBean()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new EventFilter());
        registrationBean.addUrlPatterns("/*"); // 서블릿 등록 빈 처럼 패턴을 지정해 줄 수 있다.
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);   // 필터의 동작 순서 지정
        return registrationBean;
    }

}
```

- 필터를 추가하게 되면 컨트롤러의 요청을 처리하기 전에 필터를 거친후 해당 요청을 처리한다.

![필터](https://t1.daumcdn.net/cfile/tistory/991A14465B35E59A08)


## 필터와 인터셉터

### 필터
- DispatcherServlet 앞단에서 처리


### 인터셉터
- DispatcherServlet에서 Handler로 가기 전에 처리

#### 주로 필터는 전역적으로 처리해야할 로직의 경우(인코딩, 보안관련 처리 등)에 사용, 인터셉터는 요청에 대한 디테일한 처리(인증, 권한)를 한다. 