package com.ritwik.greeting;

import org.springframework.stereotype.Component;

@Component("french")
public class FrenchGreetingService implements GreetingService {
    @Override
    public void greet() {
        System.out.println("Greeting in French...");
    }
}
