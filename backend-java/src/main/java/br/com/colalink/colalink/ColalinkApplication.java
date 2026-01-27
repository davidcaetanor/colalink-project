package br.com.colalink.colalink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ColalinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColalinkApplication.class, args);
	}

}
