package com.demo.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.lang.annotation.Annotation;
import java.util.EnumSet;

public class MyWebInitializer /*implements WebApplicationInitializer*/ {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);

        // context.register(SpringMVCConfig.class);

         /*ServletRegistration.Dynamic dynamic=servletContext.addServlet("dispatcher",new DispatcherServlet(context));
         dynamic.setLoadOnStartup(1);
         dynamic.addMapping("/");*/

/*        CharacterEncodingFilter filter=new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        FilterRegistration.Dynamic filterDynamic=servletContext.addFilter("charFIlter",filter);
        filterDynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD,DispatcherType.REQUEST),true,"/*");


        ContextLoaderListener loaderListener=new ContextLoaderListener();
        servletContext.setInitParameter("contextConfigLocation","classpath:spring-config.xml");
        servletContext.addListener(loaderListener);*/





    }
}
