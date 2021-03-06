package com.ritwik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        /**
         * retrieve the bean from the spring container
         */

        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.ritwik");

        Person person = (Person) ctx.getBean("person");

        Car car = (Car) ctx.getBean("car");

        System.out.println(person);

        System.out.println(car);
    }
}
