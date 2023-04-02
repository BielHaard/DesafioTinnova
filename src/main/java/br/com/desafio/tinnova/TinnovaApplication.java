package br.com.desafio.tinnova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.desafio")
public class TinnovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinnovaApplication.class, args);
	}

}
