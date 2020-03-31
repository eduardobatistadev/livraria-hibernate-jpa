package com.livraria.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.livraria.config.HibernateConfig;
import com.livraria.model.Cliente;

public class DaoCliente {

	public void salvar(Cliente cliente) {
		Transaction transacao = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			transacao = session.beginTransaction();
			session.save(cliente);
			transacao.commit();
			
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}	
			e.printStackTrace();
		}
	}
	public List<Cliente> findAll(){
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			
		return session.createQuery("from Cliente", Cliente.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
