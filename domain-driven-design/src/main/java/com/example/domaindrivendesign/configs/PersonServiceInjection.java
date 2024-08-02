package com.example.domaindrivendesign.configs;

import com.example.domaindrivendesign.repositories.PersonRepository;
import com.example.domaindrivendesign.services.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonServiceInjection {

    @Bean
    public PersonServiceImpl getPersonService(PersonRepository personRepository) {
        return new PersonServiceImpl(personRepository);
    }
}
