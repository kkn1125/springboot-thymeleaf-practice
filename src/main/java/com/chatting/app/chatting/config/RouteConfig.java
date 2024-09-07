package com.chatting.app.chatting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class RouteConfig implements WebMvcConfigurer {
  private static final String[] RESOURCE_LOCATIONS = {
      "classpath:/META-INF/resources/", "classpath:/resources/",
      "classpath:/static/", "classpath:/public/", "classpath:/templates/" };

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (registry.hasMappingForPattern("/js/**")) {
      registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    }
    if (registry.hasMappingForPattern("/css/**")) {
      registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
    }
    registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
  }

}
