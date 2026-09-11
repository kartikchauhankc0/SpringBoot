package in.strikes.InterceptorDemo.config;


import in.strikes.InterceptorDemo.interceptor.AuthenticationInterceptor;
import in.strikes.InterceptorDemo.interceptor.AuthorizationInterceptor;
import in.strikes.InterceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public AuthorizationInterceptor authorizationInterceptor;
    public LoggingInterceptor loggingInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;

    public WebConfig (LoggingInterceptor loggingInterceptor,
                      AuthenticationInterceptor authenticationInterceptor, AuthorizationInterceptor authorizationInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor=authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry){

        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**") // we add authentication interceptor only in this api point
                .excludePathPatterns("/api/auth/login", "/api/public") //if we want to show something to the user that is public and also something without login the page
                .order(1);


        registry.addInterceptor(authorizationInterceptor)
                .order(2);

        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**") //"/api/*" =means only one word after api with two star ** any number words after api
                .excludePathPatterns("/admins/**")
                .order(3);

    }
}
