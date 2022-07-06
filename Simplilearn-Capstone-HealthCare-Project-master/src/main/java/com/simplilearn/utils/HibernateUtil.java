package com.simplilearn.utils;

import com.simplilearn.hibernate.entity.AddressDetails;
import com.simplilearn.hibernate.entity.ProductDetails;
import com.simplilearn.hibernate.entity.UserDetails;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null || sessionFactory.isClosed()){
            try {
                Configuration configuration = new Configuration();

                //Hibernate settings equivalent to hibernate.cfg.xmls properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, ConfigurationFile.getProperty("jdbc.driver"));
                settings.put(Environment.URL, ConfigurationFile.getProperty("jdbc.url"));
                settings.put(Environment.USER, ConfigurationFile.getProperty("jdbc.username"));
                settings.put(Environment.PASS, ConfigurationFile.getProperty("jdbc.password"));
                settings.put(Environment.DIALECT, ConfigurationFile.getProperty("jdbc.dialect"));
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(UserDetails.class);
                configuration.addAnnotatedClass(AddressDetails.class);
                configuration.addAnnotatedClass(ProductDetails.class);

                 serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;

    }

    public static void closeSessionFactory(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
        if(serviceRegistry != null){
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

}
