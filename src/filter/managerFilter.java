package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "managerFilter")
public class managerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(3333);
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        int flag=0;
        String name="manager";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
           if (cookie.getValue().equals(name)) {
               chain.doFilter(req, resp);
           }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
