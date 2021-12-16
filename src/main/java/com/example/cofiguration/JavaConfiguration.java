package com.example.cofiguration;

import com.example.entity.User;
import com.example.repo.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.security")
public class JavaConfiguration {


    @Bean
    public UserRepository userRepository () {
        System.out.println("Bean UserRepository is work");
        return new UserRepository();
    }

    @Bean
    public User user () {
        System.out.println("Bean User is work");
        return new User();
    }

}
