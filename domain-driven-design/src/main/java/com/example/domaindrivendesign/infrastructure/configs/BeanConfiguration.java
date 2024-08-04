package com.example.domaindrivendesign.infrastructure.configs;

import com.example.domaindrivendesign.domain.repositories.PersonRepository;
import com.example.domaindrivendesign.domain.services.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PersonServiceImpl getPersonService(PersonRepository personRepository) {
        return new PersonServiceImpl(personRepository);
    }
}
