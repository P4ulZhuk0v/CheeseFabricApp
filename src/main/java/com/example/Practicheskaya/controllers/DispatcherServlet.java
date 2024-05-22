package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Material;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MainPageController.class, MaterialsController.class, MarkUpController.class, SellsController.class, CheeseController.class};
    }

//    , MaterialsController.class, MarkUpController.class, SellsController.class

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/shop/**", "/materials/**", "/markup/**", "/sells/**, /cheese/**"};
    }

//    , "/materials", "/markup", "/sells
}
