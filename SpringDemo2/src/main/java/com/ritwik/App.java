package com.ritwik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.ritwik");

        Person person = (Person) ctx.getBean("person");

        System.out.println(person.toString());
    }
}