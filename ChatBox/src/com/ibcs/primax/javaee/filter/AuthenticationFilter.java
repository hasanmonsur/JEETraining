package com.ibcs.primax.javaee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Oronno on 4/22/2015.
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do things here before process request");
        chain.doFilter(req, resp);
        System.out.println("Do things here after processing response from servlets/jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
