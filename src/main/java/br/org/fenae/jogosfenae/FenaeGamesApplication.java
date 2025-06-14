package br.org.fenae.jogosfenae;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FenaeGamesApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(FenaeGamesApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Iniciando a aplicação");
		SpringApplication.run(FenaeGamesApplication.class, args);
		LOGGER.info("Aplicação iniciada");
	}

}
