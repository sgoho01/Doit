package com.ghsong.filter.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Song.gunho
 * <p>
 * Date: 2019-04-30
 */
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
