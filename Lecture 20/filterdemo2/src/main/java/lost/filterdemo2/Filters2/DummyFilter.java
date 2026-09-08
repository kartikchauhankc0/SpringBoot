package lost.filterdemo2.Filters2;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class DummyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        System.out.println("dummy filter example");

        chain.doFilter(request,response);



    }
}
