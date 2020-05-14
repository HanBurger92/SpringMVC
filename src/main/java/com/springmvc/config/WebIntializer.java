package com.springmvc.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // DispatcherServlet Configuration
    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }

    // Spring IOC Configuration
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[] {RootConfig.class};
    }

    // DispatcherServlet Mapping
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[] {WebConfig.class};
    }
}
