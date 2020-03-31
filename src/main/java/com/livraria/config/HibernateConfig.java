package com.livraria.config;

import java.util.Properties
;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.livraria.model.Autor;
import com.livraria.model.Cliente;
import com.livraria.model.Escreve;
import com.livraria.model.Genero;
import com.livraria.model.ItensDaVenda;
import com.livraria.model.Livro;
import com.livraria.model.Venda;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties prop = new Properties();
				
				// Banco de Dados
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate_livraria2?useSSL=false");
				prop.put(Environment.USER, "qintess");
				prop.put(Environment.PASS, "123456");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				prop.put(Environment.SHOW_SQL, "true"); // em ambiente produtivo é false
				prop.put(Environment.HBM2DDL_AUTO, "update"); // em ambiente produtivo nunca utilizar create ou create-drop
				
				configuration.setProperties(prop);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Autor.class);
				configuration.addAnnotatedClass(Escreve.class);
				configuration.addAnnotatedClass(Genero.class);
				configuration.addAnnotatedClass(ItensDaVenda.class);
				configuration.addAnnotatedClass(Livro.class);
				configuration.addAnnotatedClass(Venda.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();
				
					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	// retorna a chave primaria
	public static Object getPrimaryKey(Object entidade) {
		return sessionFactory.getPersistenceUnitUtil().getIdentifier(entidade);
	}

}
