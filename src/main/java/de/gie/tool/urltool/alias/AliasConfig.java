package de.gie.tool.urltool.alias;

import de.gie.tool.urltool.alias.model.Alias;
import de.gie.tool.urltool.alias.model.AliasRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*
Config class to inject value (as bean)
Command Line Runner
Command Line Runner is an interface.
It is used to execute the code after the Spring Boot application started.
The example given below shows how to implement the Command Line Runner interface on the main class file.

 */
@Configuration
public class AliasConfig {

    @Bean
    CommandLineRunner commandLineRunner(AliasRepository repository){
        return args -> {
            Alias find = new Alias("https://www.google.co.id/",
                    "findSomething");
            Alias ask = new Alias("https://stackoverflow.com/",
                    "askSomething");

            repository.saveAll(List.of(find, ask));
        };
    }
}
