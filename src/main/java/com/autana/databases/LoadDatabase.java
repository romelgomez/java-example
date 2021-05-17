package com.autana.databases;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autana.domains.User;
import com.autana.domains.Phone;
import com.autana.repositories.UserRepository;
import com.autana.repositories.PhoneRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        List<Phone> rockyPhones = new ArrayList<>();
        rockyPhones.add(new Phone("+51900777000", "00001", "00002"));
        rockyPhones.add(new Phone("+51900777111", "00002", "00003"));

        List<Phone> rusoPhones = new ArrayList<>();
        rusoPhones.add(new Phone("+58711777000", "00004", "00005"));
        rusoPhones.add(new Phone("+58711777111", "00005", "00004"));

        return args -> {
            log.info("Preloading "
                    + repository.save(new User("rocky balboa", "balboa@rocky.com", "123456789", rockyPhones)));
            log.info("Preloading " + repository.save(new User("ruso", "ruso@rocky.com", "123456789", rusoPhones)));
        };
    }

    @Bean
    CommandLineRunner initDatabase(PhoneRepository repository) {
        return args -> {
        };
    }

}
