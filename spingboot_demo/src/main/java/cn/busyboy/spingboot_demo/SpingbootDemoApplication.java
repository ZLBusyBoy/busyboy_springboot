package cn.busyboy.spingboot_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties
public class SpingbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootDemoApplication.class, args);
    }

}
