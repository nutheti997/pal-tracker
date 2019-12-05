package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;

@Configuration
public class BeanConfiguration {

    @Bean
    public JdbcTimeEntryRepository getTimeEntryRepository(DataSource ds){
       return new JdbcTimeEntryRepository(ds);
    }

}
