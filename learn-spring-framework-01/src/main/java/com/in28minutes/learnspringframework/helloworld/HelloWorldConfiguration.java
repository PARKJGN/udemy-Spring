package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address){};
record Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {

    private String name;
    private int age;
    private Address address2;

    @Bean
    public String name(){
        return "Ranga";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        // name, age, address2
        return new Person(name, age, address3);
    }
    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address){
        // name, age, address2
        return new Person(name, age, address);
    }
    @Bean
    public Person person5Qualifier(String name, int age,@Qualifier("address3qualifier") Address address){
        // name, age, address2
        return new Person(name, age, address);
    }

    @Bean(name="address2")
    @Primary
    public Address address(){
        return new Address("Seoul", "guro");
    }

    @Bean(name="address3")
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("Motinagar", "Hyderabad");
    }


}
