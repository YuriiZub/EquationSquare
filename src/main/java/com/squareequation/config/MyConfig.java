package com.squareequation.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Web configurer class
 * @author Created by Yurii on 5/4/2019.
 *
 * @version 1.0.2
 */
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configuration
@ComponentScan(basePackages = "com.squareequation")
@Import({DBConfig.class})

public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}
