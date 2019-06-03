package org.cts.util;

import java.util.Properties;

import org.cts.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


public class HibUtil {
	
	public static Session getSession()
	{
		Configuration configuration=new Configuration();
		Properties settings=new Properties();
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/employee");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "root");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
		settings.put(Environment.SHOW_SQL, true);
		settings.put(Environment.HBM2DDL_AUTO, "update");
		configuration.setProperties(settings);
		configuration.addAnnotatedClass(Emp.class);
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory factory=configuration.buildSessionFactory(registry);
		Session session=factory.openSession();
		return session;
		/*
		 * StandardServiceRegistry registry=null; SessionFactory factory=null; Session
		 * session=null; registry=new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 * MetadataSources sources=new MetadataSources(registry); Metadata
		 * metadata=sources.getMetadataBuilder().build();
		 * factory=metadata.getSessionFactoryBuilder().build();
		 * session=factory.openSession(); return session;
		 */
		
	}

}
