//package com.lxk.login.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @Description 支持跨域请求
// * @Author zhaoxu@e6yun.com
// * @Created Date 2019/12/17 12:29
// * @Modifier
// * @Modified Date
// * @Modified Remark
// * @Version 1.0
// **/
//@Component
//@Order(1)
//public class CorsProcessFilter implements Filter {
//
//    /**
//     * 这里为支持的请求头，如果有自定义的header字段请自己添加
//     */
//    private static final String ALLOWED_HEADERS = "x-requested-with,authorization,Content-Type,Authorization,credential,X-XSRF-TOKEN,token,sign,timestamp";
//    private static final String ALLOWED_METHODS = "GET,HEAD,POST,PUT,DELETE,OPTIONS";
//    private static final String ALLOWED_ORIGIN = "*";
//    private static final String ALLOWED_EXPOSE = "*";
//    /**
//     * 它告诉了服务器在多少秒内,不需要再发送预检请求,可以缓存该结果,即只发送真正的请求,不同浏览器有不同的上限.在Firefox中,上限是24h(即86400秒),而在Chrome中则是10min(即600秒).
//     */
//    private static final String MAX_AGE = "18000";
//    static Logger logger = LoggerFactory.getLogger(CorsProcessFilter.class);
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        // 允许跨域
////        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ALLOWED_ORIGIN);
////        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, ALLOWED_HEADERS);
////        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, ALLOWED_METHODS);
////        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ALLOWED_EXPOSE);
////        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//}
