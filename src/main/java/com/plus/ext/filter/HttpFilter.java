package com.plus.ext.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Http请求过滤
 */
public abstract class HttpFilter implements Filter {
    private FilterConfig config;

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        init();
    }

    public void init() throws ServletException {
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) {
        try {
            if (request instanceof HttpServletRequest) {
                doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
            }
        } catch (Exception e) {
            return;
        }
        return;
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
    }

    public String getInitParameter(String name) {
        return config.getInitParameter(name);
    }

    public FilterConfig getFilterConfig() {
        return config;
    }

    public ServletContext getServletContext() {
        return config.getServletContext();
    }
}
