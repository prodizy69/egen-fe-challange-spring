package com.egen.DB;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Sateesh on 10/1/2016.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();


    private static SessionFactory buildSessionFactory()
    {
        Logger LOGGER =Logger.getLogger(HibernateUtil.class);
        try
        {
            if (sessionFactory == null)
            {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
              LOGGER.info("Configuration is  :" +configuration);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
                builder.applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
            return sessionFactory;
        } catch (Throwable ex)
        {
            LOGGER.info("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        getSessionFactory().close();
    }
}
