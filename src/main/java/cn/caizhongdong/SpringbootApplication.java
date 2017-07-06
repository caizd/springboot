package cn.caizhongdong;

import cn.caizhongdong.rest.app.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@MapperScan("com.example.mapper")
public class SpringbootApplication extends SpringBootServletInitializer{
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
		// our rest resources will be available in the path /rest/*
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
