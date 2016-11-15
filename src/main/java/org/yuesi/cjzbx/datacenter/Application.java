package org.yuesi.cjzbx.datacenter;


import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("org.yuesi.cjzbx.datacenter.model.mapper")
@SpringBootApplication
@ServletComponentScan
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer  {

	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(18081);
		
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
