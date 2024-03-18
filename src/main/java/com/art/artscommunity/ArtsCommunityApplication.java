package com.art.artscommunity;

import com.art.artscommunity.model.User;
import com.art.artscommunity.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArtsCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtsCommunityApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepo repo) {
        return (args) -> {
            User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
            repo.save(user1);
            repo.save(user2);
        };
    }
}
