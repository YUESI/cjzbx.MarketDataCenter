package org.yuesi.cjzbx.datacenter;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("org.yuesi.cjzbx.datacenter.domain.mapper")
//@ServletComponentScan
//@EnableScheduling
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
