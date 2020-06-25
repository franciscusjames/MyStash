package br.com.grupolibra.automacaodespacho.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "cmsEntityManagerFactory", 
		transactionManagerRef = "cmsTransactionManager", 
		basePackages = {"br.com.grupolibra.automacaodespacho.repositories.cms"}
)
public class CMSDbConfig {
	
	@Value("${cms.datasource.username}")
	private String user;

	@Value("${cms.datasource.password}")
	private String password;

	@Value("${cms.datasource.url}")
	private String url;

	@Bean(name = "cmsDataSource")
	@ConfigurationProperties(prefix = "cms.datasource")
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername(user);
		driverManagerDataSource.setPassword(password);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		return driverManagerDataSource;
	}

	@Bean(name = "cmsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean cmsEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("cmsDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("br.com.grupolibra.automacaodespacho.models.cms").persistenceUnit("cms").build();
	}

	@Bean(name = "cmsTransactionManager")
	public JpaTransactionManager cmsTransactionManager(
			@Qualifier("cmsEntityManagerFactory") EntityManagerFactory cmsEntityManagerFactory) {
		return new JpaTransactionManager(cmsEntityManagerFactory);
	}
	
}