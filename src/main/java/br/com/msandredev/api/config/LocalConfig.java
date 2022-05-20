package br.com.msandredev.api.config;

import br.com.msandredev.api.domain.User;
import br.com.msandredev.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Andre Santos", "andresantos@gmail.com", "1234");
        User u2 = new User(null, "Jão das Cove", "jaocove@gmail.com", "1234");

        repository.saveAll(List.of(u1, u2));
    }
}
