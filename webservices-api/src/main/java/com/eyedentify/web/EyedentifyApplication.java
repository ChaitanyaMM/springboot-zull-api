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
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@Controller
//@ComponentScan(basePackages = {"com.eyedentify.Repository"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories("com.eyedentify.Repository")

@ComponentScan(basePackages ={"com.eyedentify.Repository","com.eyedentify.Controller"})
@Configuration
//@EnableScheduling
//@EnableJpaRepositories("com.eyedentify.Repository")
@Import(value = {SecurityConfiguration.class})
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
