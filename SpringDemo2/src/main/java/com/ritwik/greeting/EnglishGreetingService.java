package com.ritwik.greeting;

import org.springframework.stereotype.Component;

@Component("english")
public class EnglishGreetingService implements GreetingService {
    @Override
    public void greet() {
        System.out.println("Greeting in English...");
    }
}
