package com.ritwik.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.ritwik.greeting");

        MyApp myApp = (MyApp) ctx.getBean("myApp");

        myApp.sendMessage();
    }
}