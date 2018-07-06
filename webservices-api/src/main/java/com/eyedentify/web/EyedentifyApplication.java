package com.eyedentify.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
/*@EnableDiscoveryClient*/
@EnableEurekaClient
@EnableFeignClients
@Controller
@ComponentScan(basePackages = "com")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})

public class EyedentifyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EyedentifyApplication.class, args);
	}
	
	@RequestMapping(value="/")
	@ResponseBody
    public String home() {
        return "Hello Web-API!!...";
    }

}
