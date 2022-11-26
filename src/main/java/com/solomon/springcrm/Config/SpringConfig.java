package com.solomon.springcrm.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.solomon.springcrm")
@EnableTransactionManagement
@PropertySource({"classpath:persistence-mysql.properties"})
public class SpringConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource myDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        try {
            comboPooledDataSource.setDriverClass(this.env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        this.logger.info("jdbc url: " + this.env.getProperty("jdbc.url"));
        this.logger.info("jdbc user: " + this.env.getProperty("jdbc.user"));


        comboPooledDataSource.setJdbcUrl(this.env.getProperty("jdbc.url"));
        comboPooledDataSource.setUser(this.env.getProperty("jdbc.user"));
        comboPooledDataSource.setPassword(this.env.getProperty("jdbc.password"));

        comboPooledDataSource.setInitialPoolSize(this.getIntProperty("connection.pool.initialPoolSize"));
        comboPooledDataSource.setMinPoolSize(this.getIntProperty("connection.pool.minPoolSize"));
        comboPooledDataSource.setMaxPoolSize(this.getIntProperty("connection.pool.maxPoolSize"));
        comboPooledDataSource.setMaxIdleTime(this.getIntProperty("connection.pool.maxIdleTime"));

        return comboPooledDataSource;

    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", this.env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", this.env.getProperty("hibernate.show_sql"));

        return properties;

    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        // Create Session factory
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        // Set Session properties
        localSessionFactoryBean.setHibernateProperties(this.getHibernateProperties());
        localSessionFactoryBean.setDataSource(this.myDataSource());
        localSessionFactoryBean.setPackagesToScan(this.env.getProperty("hibernate.packagesToScan"));

        return localSessionFactoryBean;

    }

    @Bean(name = "transactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        // Set up the transaction manager
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        // Set up the session factory in the transaction manager
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;

    }


    private int getIntProperty(String prop) {
        String property = this.env.getProperty(prop);
        int intProperty = Integer.parseInt(property);
        return intProperty;
    }


}
