package github.fintechecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FintechEcommerceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FintechEcommerceApiApplication.class, args);
    }
}
