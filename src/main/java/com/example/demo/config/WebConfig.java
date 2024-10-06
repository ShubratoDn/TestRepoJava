package com.example.demo.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Configuration
public class WebConfig implements WebMvcConfigurer {

	//IT WILL ALLOW ANY SUFFIX
	
//	@Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(true)
//                  .setPathMatcher(new AntPathMatcher())
//                  .setUseTrailingSlashMatch(true);
//    }
    
//	@Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        // Enable suffix matching
//        configurer.setUseSuffixPatternMatch(true)
//                  .setPathMatcher(new AntPathMatcher())
//                  .setUseTrailingSlashMatch(true)
//                  // Define ".mySuffix" as the only allowed suffix
//                  .setPatternParser(new PathPatternParser() {
//                      @Override
//                      public PathPattern parse(String pattern) {
//                          if (!pattern.endsWith(".html")) {
//                              pattern += ".html";
//                          }
//                          return super.parse(pattern);
//                      }
//                  });
//    }
//	
//	@Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(true)
//                  .defaultContentType(MediaType.TEXT_HTML);
//    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true);
    }

}
