package com.ghsong.filter.config;

import com.ghsong.filter.filter.EventFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-30
 */
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
