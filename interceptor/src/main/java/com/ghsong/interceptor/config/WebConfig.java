package com.ghsong.interceptor.config;

import com.ghsong.interceptor.interceptor.EventInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-05-07
 */
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
