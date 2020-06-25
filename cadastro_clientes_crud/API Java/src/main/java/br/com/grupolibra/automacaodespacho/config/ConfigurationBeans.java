package br.com.grupolibra.automacaodespacho.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationBeans {
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private int port;
	
	@Value("${spring.mail.username}")
	private String usename;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private Boolean auth;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private Boolean starttls;

	@Value("${server.port.http}")
	private int serverPortHttp;

	@Value("${server.port.https}")
	private int serverPortHttps;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build(); }

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(host);
		mailSender.setPort(port);

		mailSender.setUsername(usename);
		mailSender.setPassword(password);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.debug", "true");

		return mailSender; 	}

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.setPort(serverPortHttp);
		return tomcat; 	}

}