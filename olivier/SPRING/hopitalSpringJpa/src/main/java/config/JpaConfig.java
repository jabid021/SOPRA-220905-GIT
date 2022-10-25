package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//classe de configuration des objets pour utilisation de jpa
@Configuration
//annotation pour la gestion des transactions avec notre transactionManager
@EnableTransactionManagement
@ComponentScan({"service"})
//activation des repository de spring-data-jpa
//definition de l'emplacement des interfaces
@EnableJpaRepositories(basePackages = "repository")
public class JpaConfig {

	// configuration de la dataSource (base de donnee)
	// !!!!bien prendre celle qui vient de javax.sql
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// depend de la base utilisée
		// pour mysql
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// url a adapter en fonction de l'installation
		// dataSource.setUrl("jdbc:mysql://localhost:3306/hopital");
		// dataSource.setUsername("root");
		// dataSource.setPassword("");

		// pour postgres
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/hopital");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");

		dataSource.setMaxTotal(5);

		return dataSource;
	}

	// configuration de l'EntityManagerFactory
	// construit à partir de la dataSource
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		// packages contenant les @Entity
		emf.setPackagesToScan("model");
		// on definit Hibernate comme implementation de JPA
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		// dialect pour mysql
		// properties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQL5InnoDBDialect");
		// dialect pour postgres
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		emf.setJpaProperties(properties);
		return emf;
	}
	
	//gestionnaire de transaction
	//construit pour gerer les transactions sur l'entityManagerFactory injecté
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	//bean optionel mais tres fortement recommandé pour mon confort
	//transformer les Exceptions de Jpa/Hibernate en exception spring de type DataAccessException
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
