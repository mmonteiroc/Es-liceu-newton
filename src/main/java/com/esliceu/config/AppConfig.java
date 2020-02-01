package com.esliceu.config;

import com.esliceu.filter.LogedUserFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.esliceu")
@PropertySource("classpath:/file.properties")
public class AppConfig implements WebMvcConfigurer {


    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /*
     * INTERCEPTORS
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		/*registry.addInterceptor(new LocaleChangeInterceptor());
		registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
		registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");*/

        registry.addInterceptor(new LogedUserFilter()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
