package com.example.domaindrivendesign.framework;

import com.example.domaindrivendesign.domains.repositories.PersonRepository;
import com.example.domaindrivendesign.domains.services.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonServiceInjection {

    @Bean
    public PersonServiceImpl getPersonService(PersonRepository personRepository) {
        return new PersonServiceImpl(personRepository);
    }
}
