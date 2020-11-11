package com.example.merchantoffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MerchantOfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantOfferApplication.class, args);
	}

}
