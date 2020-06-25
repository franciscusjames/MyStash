package br.com.grupolibra.automacaodespacho;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableScheduling
public class ProjetoPadraoApplication extends SpringBootServletInitializer {
	
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProjetoPadraoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPadraoApplication.class, args);
	}

}