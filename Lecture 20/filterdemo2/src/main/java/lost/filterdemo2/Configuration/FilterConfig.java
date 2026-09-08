package lost.filterdemo2.Configuration;


import lost.filterdemo2.Filters2.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean(){

        FilterRegistrationBean<DummyFilter> registrationBean =
                                    new FilterRegistrationBean<>();


        registrationBean.setFilter(new DummyFilter());

        //registrationBean.setOrder(1);

        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
