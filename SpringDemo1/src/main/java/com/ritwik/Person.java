package com.ritwik;

import org.springframework.stereotype.Component;


/**
 * it will create a person bean and keep it inside spring container
 */
@Component
public class Person {

    private String name;
    private int age;

    public void dance() {
        System.out.println("Dancing in the tunes of Spring");
    }
}
