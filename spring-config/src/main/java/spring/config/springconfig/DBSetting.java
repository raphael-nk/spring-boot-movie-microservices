package spring.config.springconfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Configuration
@ConfigurationProperties("db") // map db. in properties file
public class DBSetting {
    private String connection; 
    private String host; 
    private int port;
}
