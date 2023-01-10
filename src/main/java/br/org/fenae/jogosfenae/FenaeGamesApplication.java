package br.org.fenae.jogosfenae;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FenaeGamesApplication {

	private static Logger logger = LoggerFactory.getLogger(FenaeGamesApplication.class);

	public static void main(String[] args) {
		//System.setProperty("server.port", "8888");
		logger.info("Iniciando a aplicação");
		SpringApplication.run(FenaeGamesApplication.class, args);
		logger.info("Aplicação iniciada");
	}

}
