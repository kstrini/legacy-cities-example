package io.pivotal.cna.config.web;

import io.pivotal.cna.config.data.DataConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses() {return new Class<?>[]{DataConfiguration.class};}


    @Override
    protected Class<?>[] getServletConfigClasses() {return new Class<?>[]{WebConfiguration.class};}

    @Override
    protected String[] getServletMappings() {return new String[]{"/"};}
}
