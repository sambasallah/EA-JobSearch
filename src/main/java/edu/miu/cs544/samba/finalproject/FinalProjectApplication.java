package edu.miu.cs544.samba.finalproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Job Search API", version = "1.0", description = "Job Search API Info"))
@EnableJms
public class FinalProjectApplication {

    public static void main(String[] args) {
        System.out.println("App Start");
        SpringApplication.run(FinalProjectApplication.class, args);
        System.out.println("App End");
    }


}
