package in.strikes.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    // Pre handle handles all the functionality (logics) we want to perform before calling the controller
    public boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler){
//        if(handler instanceof HandlerMethod method){
//
//            String controllerName=method.getBeanType().getName();
//            String methodName=method.getMethod().getName();
//
//            System.out.println("Pre handle Interceptor");
//
//            System.out.println("controllerName = "+ controllerName);
//            System.out.println("methodName = " + methodName);
//        }

        System.out.println("incoming request------------");
        System.out.println("HTTP method : "+ request.getMethod());
        System.out.println("Request uri : "+ request.getRequestURI());
        System.out.println("Request parameter : " +request.getQueryString());
        System.out.println("Client IP : "+ request.getRemoteAddr());
        System.out.println("Header : "+ request.getHeader("token"));

        if(handler instanceof HandlerMethod method){
            System.out.println("Controller Name = "+ method.getBeanType().getName());
            System.out.println("Method Name = "+ method.getMethod().getName());

        }

        return true; // if we are return true we want to tell our spring mvc that we want to move forward
        // that we want to call our next controller or our next interceptor

    }

//    @Override
//    // after out controller finish
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler,
//                            ModelAndView modelAndView){ // with the help of model and view we can show out user the static page of HTML or jsp response instead of JSON format
//
//       // System.out.println("post handle called  ");
//
//
//    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                               HttpServletResponse response,
                               Object handler,
                                Exception ex) throws Exception {
       // System.out.println("after completion called ");

        System.out.println("Response Status : " + response.getStatus());
    }


}
