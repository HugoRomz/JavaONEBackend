package com.aluracursos.desafio_Springboot;

import com.aluracursos.desafio_Springboot.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();

		principal.mostrarMenu();
	}
}
