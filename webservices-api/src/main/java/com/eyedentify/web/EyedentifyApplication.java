package com.eyedentify.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@Controller
public class EyedentifyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EyedentifyApplication.class, args);
	}
	
	@RequestMapping(value="/")
	@ResponseBody
    public String home() {
        return "Hello API!!...";
    }

}
