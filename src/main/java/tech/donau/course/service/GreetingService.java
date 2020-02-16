package tech.donau.course.service;

import tech.donau.course.config.GreetingConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    @Inject
    GreetingConfig greetingConfig;

    public String sayHello() {
        return greetingConfig.getPrefix().orElse("_")
                + greetingConfig.getName()
                + greetingConfig.getSuffix()
                + " your country is " + greetingConfig.getCountry().getName();
    }

    public String sayHello(String name) {
        return String.format("Hello %s, your id is %s",
                name,
                UUID.randomUUID().toString()
        );
    }
}
