package com.in28minutes.learnspringframework.examples.z00;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ContextLauncherApplication {

    public static void main(String[] args){

        var context = new AnnotationConfigApplicationContext
                (ContextLauncherApplication.class);

        System.out.println(context.getBean(BusinessCalculationService.class).findMax());
    }
}
