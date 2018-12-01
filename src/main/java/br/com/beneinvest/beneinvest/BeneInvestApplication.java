package br.com.beneinvest.beneinvest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BeneInvestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneInvestApplication.class, args);
    }
}
