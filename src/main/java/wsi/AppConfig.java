package wsi;



import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig extends WebMvcAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix="my.datasource")
    public DataSource myDataSource() {
        return DataSourceBuilder.create().build();
    }

    }