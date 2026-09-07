package lost.filterdemo2.Filters2;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component

public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {


        HttpServletRequest httpRequest=
                (HttpServletRequest) request;

        HttpServletResponse httpResponse=
                (HttpServletResponse) response;

        ContentCachingResponseWrapper wrappedResponse=
                new ContentCachingResponseWrapper(httpResponse);

        chain.doFilter(request,wrappedResponse);

        byte[] originalBodyBytes=
                wrappedResponse.getContentAsByteArray();

        String bodyBytes =
                new String(originalBodyBytes);

        String modifiedBody=
                """ 
                        {
                          "originalResponse" : %s,
                          "appname" : "Student Management System"
                        
                        }
                       
                        """.formatted(bodyBytes);

        wrappedResponse.resetBuffer();

        wrappedResponse.getWriter().write(modifiedBody);

        wrappedResponse.copyBodyToResponse();

    }
}
