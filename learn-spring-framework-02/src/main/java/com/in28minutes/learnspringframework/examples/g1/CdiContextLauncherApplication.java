package com.in28minutes.learnspringframework.examples.g1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

//@Component
@Named
class BusinessService{
    private DataService dataService;

    public DataService getDataService() {

        return dataService;
    }
    //@Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService{

}
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args){

        var context =
                new AnnotationConfigApplicationContext
                (CdiContextLauncherApplication.class);
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println(context.getBean(BusinessService.class)
                .getDataService());
    }
}
