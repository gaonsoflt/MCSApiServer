//package com.gaonsoft.mcs.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///* 
// * mybatis 
// */
//@Configuration
//@MapperScan(basePackages={"com.gaonsoft.mcs.sample.mapper"})
//@EnableTransactionManagement
//public class DatabaseConfig {
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
//		return sessionFactory.getObject();
//	}
//
//	@Bean(name="sqlSessionTemplate")
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
//		final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//		return sqlSessionTemplate;
//	}
//}
//
////@Configuration
////@EnableTransactionManagement
////public class DatabaseConfig {
////
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
////        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
////        em.setDataSource(dataSource());
////        em.setPackagesToScan("com.gaonsoft.mcs.sample.jpa");
//// 
////        // persistence 설정
////        Properties properties = new Properties();
////        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
////        properties.setProperty("hibernate.show_sql", "true");
//// 
////        // 각 구현체의 프로퍼티 확장 및 설정
////        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
////        em.setJpaVendorAdapter(jpaVendorAdapter);
////        em.setJpaProperties(properties);
////        return em;
////    }
//// 
////    // H2 DB 설정
////    @Bean(destroyMethod = "shutdown")
////    public EmbeddedDatabase dataSource() {
////        return new EmbeddedDatabaseBuilder()
////                .setType(EmbeddedDatabaseType.H2)
////                .setName("slipp")
////                .build();
////    }
//// 
////    // Transaction 설정
////    @Bean
////    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
////        JpaTransactionManager transactionManager = new JpaTransactionManager();
////        transactionManager.setEntityManagerFactory(emf);
////        return transactionManager;
////    }
////}