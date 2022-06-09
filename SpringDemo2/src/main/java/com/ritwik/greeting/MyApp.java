package com.ritwik.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyApp {

    @Autowired
    @Qualifier("french")
    GreetingService greetingService;

    public void sendMessage() {
        greetingService.greet();
    }
}
