package com.alura.literalura_challenge;

import com.alura.literalura_challenge.principal.Principal;
import com.alura.literalura_challenge.repository.AutorRepository;
import com.alura.literalura_challenge.repository.LibroRepository;
//import com.alura.literalura_challenge.service.MenuService;
import com.alura.literalura_challenge.service.AutorService;
import com.alura.literalura_challenge.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraChallengeApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository, libroService, autorRepository, autorService);
		principal.selectorDeOpcion();
	}
}
