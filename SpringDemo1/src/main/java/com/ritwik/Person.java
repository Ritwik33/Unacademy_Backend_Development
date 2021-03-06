package com.ritwik;

import org.springframework.stereotype.Component;


/**
 * it will create a person bean and keep it inside spring container
 */
@Component
public class Person {

    private String name;
    private int age;

    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void dance() {
        System.out.println("Dancing in the tunes of Spring");
    }
}
