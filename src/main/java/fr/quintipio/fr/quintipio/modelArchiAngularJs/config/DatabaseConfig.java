package fr.quintipio.fr.quintipio.modelArchiAngularJs.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
}

/**
 * For entityManager
 *
 *
 @Bean
 public DataSource dataSource() {
 DriverManagerDataSource dataSource = new DriverManagerDataSource();
 dataSource.setDriverClassName(env.getProperty("db.driver"));
 dataSource.setUrl(env.getProperty("db.url"));
 dataSource.setUsername(env.getProperty("db.username"));
 dataSource.setPassword(env.getProperty("db.password"));
 return dataSource;
 }

 @Bean
 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
 LocalContainerEntityManagerFactoryBean entityManagerFactory =
 new LocalContainerEntityManagerFactoryBean();

 entityManagerFactory.setDataSource(dataSource);

 // Classpath scanning of @Component, @Service, etc annotated class
 entityManagerFactory.setPackagesToScan(
 env.getProperty("entitymanager.packagesToScan"));

 // Vendor adapter
 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
 entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

 // Hibernate properties
 Properties additionalProperties = new Properties();
 additionalProperties.put(
 "hibernate.dialect",
 env.getProperty("hibernate.dialect"));
 additionalProperties.put(
 "hibernate.show_sql",
 env.getProperty("hibernate.show_sql"));
 additionalProperties.put(
 "hibernate.hbm2ddl.auto",
 env.getProperty("hibernate.hbm2ddl.auto"));
 entityManagerFactory.setJpaProperties(additionalProperties);

 return entityManagerFactory;
 }

 @Bean
 public JpaTransactionManager transactionManager() {
 JpaTransactionManager transactionManager =
 new JpaTransactionManager();
 transactionManager.setEntityManagerFactory(
 entityManagerFactory.getObject());
 return transactionManager;
 }

 @Bean
 public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
 return new PersistenceExceptionTranslationPostProcessor();
 }



 @Autowired
 private Environment env;

 @Autowired
 private DataSource dataSource;

 @Autowired
 private LocalContainerEntityManagerFactoryBean entityManagerFactory;
 *
 *
 *
 */