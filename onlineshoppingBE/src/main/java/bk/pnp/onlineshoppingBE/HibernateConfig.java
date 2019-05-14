package bk.pnp.onlineshoppingBE;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//CONFIGURATION OF MY DATABASE SO THAT I COUDLE BE ALBE TO UPLOAD DATA AND SELECT DATA FROM THE TABLE
@Configuration
@ComponentScan(basePackages = {"bk.pnp.onlineshoppingBE.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//LINKING TO MY H2 DATABASE
	private final static String DATABASE_URL = "jdbc:h2:./data";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	//DATASOURCE BEAN
	@Bean
	private DataSource getDataSource(){
		
		BasicDataSource ds = new BasicDataSource();
		
		//DATABASE CONNECTION PERMISSIONS
		ds.setDriverClassName(DATABASE_DRIVER);
		ds.setUrl(DATABASE_URL);
		ds.setUsername(DATABASE_USERNAME);
		ds.setPassword(DATABASE_PASSWORD);
		return ds;
	}
	
	//SESSIONFACTORY BEAN
	@Bean
	public SessionFactory getSessionFactory(DataSource ds){
		LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(ds);
		
		sfb.addProperties(getHibernateProperties());
		sfb.scanPackages("bk.pnp.onlineshoppingBE.dto");
		return sfb.buildSessionFactory();
	}
	
	//ALL THE HIBERNATE PROPERTIES THAT WILL BE RETURNED
	private Properties getHibernateProperties() {
		
		Properties ppts = new Properties();
		
		ppts.put("hibernate.dialect", DATABASE_DIALECT);
		ppts.put("hibernate.show_sql", "true");
		ppts.put("hibernate.format_sql", "true");
		return null;
	}
	
	//HIBERNATE BEAN
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sfb){
		HibernateTransactionManager tm = new HibernateTransactionManager(sfb);
		
		return tm;
	}
}
