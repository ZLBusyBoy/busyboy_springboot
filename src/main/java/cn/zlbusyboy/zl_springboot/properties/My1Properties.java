package cn.zlbusyboy.zl_springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by ling.zhang on 2018/9/9.
 */
@Component
@ConfigurationProperties(prefix = "my1")
public class My1Properties {

    private int age;
    private String name;

    @Override
    public String toString() {
        return "My1Properties{" +
                "age=" + age +
                ", name='" + name + '\'' +
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
}
