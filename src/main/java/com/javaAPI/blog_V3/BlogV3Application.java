package com.javaAPI.blog_V3;

import com.javaAPI.blog_V3.filters.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogV3Application {

	public static void main(String[] args) {
		SpringApplication.run(BlogV3Application.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthFilter> loggingFilter(){
		FilterRegistrationBean<AuthFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new AuthFilter());
		registrationBean.addUrlPatterns("/blog/*");

		return registrationBean;
	}
}
