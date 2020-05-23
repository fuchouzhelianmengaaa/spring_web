package com.demo.config;

import com.demo.common.MyConverter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.io.ClassPathResource;

import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.demo.controller","com.demo.common"})
public class SpringMVCConfig  {

    @Bean
    public FormattingConversionService conversionService(){
        FormattingConversionServiceFactoryBean factoryBean=new FormattingConversionServiceFactoryBean();
        Set<GenericConverter> set =new HashSet<>();
        set.add(new MyConverter());
        factoryBean.setConverters(set);
        return factoryBean.getObject();
    }


    @Bean
    public InternalResourceViewResolver viewResolver1(){
        InternalResourceViewResolver r=new InternalResourceViewResolver();
        r.setPrefix("/");
        r.setSuffix(".jsp");
        r.setOrder(1000);
        return  r;
    }
    @Bean
    public ResourceBundleViewResolver viewResolver2(){
        ResourceBundleViewResolver r=new ResourceBundleViewResolver();
        r.setBasename("my_views_define");
        r.setOrder(100);
        return r;
    }
    @Bean
    public XmlViewResolver viewResolver3() {
        XmlViewResolver r = new XmlViewResolver();
        ClassPathResource resource = new ClassPathResource("my_views.xml");
        r.setOrder(10);
        r.setLocation(resource);
        return r;
    }
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver r=new CommonsMultipartResolver();
        r.setDefaultEncoding("utf-8");
        r.setMaxInMemorySize(2048);
        r.setMaxUploadSize(26214400);
        r.setMaxUploadSizePerFile(5242880);
        return r;
    }
    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource r=new ResourceBundleMessageSource();
        r.setBasename("msg");
        return r;
    }
 /*  @Bean
    public Validator validation(MessageSource messageSource){
        LocalValidatorFactoryBean r=new LocalValidatorFactoryBean();
        r.setProviderClass(org.hibernate.validator.HibernateValidator.class);
        r.setValidationMessageSource(messageSource);
        return r.getValidator();
    }*/
}