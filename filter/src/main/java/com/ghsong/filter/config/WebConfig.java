package com.ghsong.filter.config;

import com.ghsong.filter.filter.TestFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-30
 * Copyright(©) 2019 by ATOSTUDY.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestFilter())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user")
                ;
    }
}
