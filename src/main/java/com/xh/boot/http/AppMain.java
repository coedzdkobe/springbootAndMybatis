package com.xh.boot.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@ServletComponentScan
public class AppMain {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
}
