package com.instaclass.instituteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class InstituteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstituteServiceApplication.class, args);
	}

}
