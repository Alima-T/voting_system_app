package voting_system_app.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @Alima-T 6/26/2022
 */

@Configuration
@ComponentScan(basePackages = "voting_system_app") //==<context:component-scan base-package="spring.rest.spring.rest" />
//@EnableWebMvc //== <aop:aspectj-autoproxy/>
@EnableTransactionManagement //==  <tx:annotation-driven transaction-manager="transactionManager" />
public class WebConfiguration {

    @Bean
    public DataSource webDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setDataSourceName("postgresql");
            dataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1:7777/voting_system?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;

    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(webDataSource());//за DataSource у нас отвечает метод webDataSource() поэтому в параметре пишем создание бина webDataSource()
        sessionFactory.setPackagesToScan("voting_system_app.model");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());//sessionFactory is an object of LocalSessionFactoryBean, which implements FactoryBean<SessionFactory>, to get sessionFactory from FactoryBean we need to .getObject()
        return transactionManager;
    }
}
