package spring.config.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class ConfigTest {
    
    @Value("${my.greeting}")      // pull up value from application.properties
    private String myGreeting;
    
    @Value("Some Static Message")
    private String someStaticMessage; // assign Some Static Message to someStaticMessage
    
    @Value("${my.hello : default value}") // add a default value
    private String sayHello; 
    
    @Value("${my.list.value}")
    private List<String> myListValue;
    
    @Value("#{${dbValues}}") //  pull up key value from properties 
    private Map<String, String> db;
    
    @Autowired
    private DBSetting db_setting;
    
    @GetMapping
    public String getGreeting(){
        return myGreeting;
    }
    
    @GetMapping("/hello")
    public String getHello(){
        return sayHello + " " + myListValue + " " +db;
    }
    
    @GetMapping("/configprops")
    public  String getDbSetting() {
        return db_setting.getHost() + ":" + db_setting.getPort();
    }
}
