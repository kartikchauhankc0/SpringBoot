package in.lost.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
//@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest=
                (HttpServletRequest) request;

        HttpServletResponse httpResponse=
                (HttpServletResponse) response;

        String token = httpRequest.getHeader("token");

        if(token ==null || !token.equals("123")){
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED );
                return;
        }
        chain.doFilter(request,response);


    }
}
