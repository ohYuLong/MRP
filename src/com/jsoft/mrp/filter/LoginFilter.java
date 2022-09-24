//package pms.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
///*
//*   防盗链的过滤器应该去拦截或者说放行哪些请求
//*   哪些请求不需要拦截？？？？？
//*   index.html，register.html，login.html，checkUser.do，getProfile.do，
//*   login.do，register.do
//*
//* */
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//
////        定义一个集合，这个集合保存的就是要放行的链接
////        严格来说，这些url应该保存到一个文本文件里。
//        List<String> urls = Arrays.asList("/MVC/index.html","/MVC/","/MVC/login.html","/MVC/register.html","/MVC/admin/login.do",
//                "/MVC/admin/addVip.do","/MVC/admin/checkUser.do","/MVC/admin/getProfile.do","/MVC/verify.do");
//
////        req.getRequestURI()能够获取到的就是类似   /MVC/success.html
//        String uri = req.getRequestURI();
////        如果当前的uri在我们需要放行的集合中，就放行，否则就拦截
//        if(urls.contains(uri)){
//            chain.doFilter(req, resp);
//            return;
//        }
////        如果登录成功，需要放行
//        String username = (String) req.getSession().getAttribute("user");
////        如果从session中获取的user是个null，说明没有登录
//        if(Objects.isNull(username)){
////            如果没有登录过，那就应该去登录
//            resp.sendRedirect(req.getContextPath() + "/login.html");
//            return;
//        }
//
//        chain.doFilter(req,resp);
//    }
//}
