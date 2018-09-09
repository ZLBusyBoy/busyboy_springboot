package cn.zlbusyboy.zl_springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Create by ling.zhang on 2018/9/9.
 */
@Component
@PropertySource("classpath:my2.properties")
@ConfigurationProperties(prefix = "my2")
public class My2Properties {

    int age;
    String name;
    String email;

    @Override
    public String toString() {
        return "My2Properties{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
