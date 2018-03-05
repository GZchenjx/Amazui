package com.jx.filter;

import com.jx.bean.User;
import com.jx.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by CHEN JX on 2017/12/12.
 */
public class UserLoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(UserLoginFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("UserLoginFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request =  (HttpServletRequest)servletRequest;
        String uri = request.getRequestURI();
        if (notFilter(uri)) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Constants.USER_IN_SESSION);
            if (user != null) {
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/");
            }
        }
    }

    @Override
    public void destroy() {
        logger.info("UserLoginFilter destory...");
    }

    private boolean notFilter(String uri) {
        return uri.equals("/") || uri.contains("/user/login") || uri.contains("/static/");
    }
}
