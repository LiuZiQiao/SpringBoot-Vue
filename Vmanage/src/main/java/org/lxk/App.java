package org.lxk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author macos
 */

@SpringBootApplication
@MapperScan(value = "org.lxk.dao")
public class App {
    public static void main(String[] args)
    {
        System.out.println("hello");
        SpringApplication.run(App.class, args);
    }

}
