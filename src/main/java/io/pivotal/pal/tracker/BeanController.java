package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanController {

    @Bean
    public TimeEntryRepository getTimeEntryRepository(){
       return new InMemoryTimeEntryRepository();
    }

}
