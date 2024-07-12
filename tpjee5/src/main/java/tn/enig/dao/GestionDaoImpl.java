package tn.enig.dao;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import tn.enig.model.Chambre;
import tn.enig.model.hotel;

public class GestionDaoImpl implements IGestionDao {
 Session session;
 public GestionDaoImpl() {
	 SessionFactory sessionFactory;

		 ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build(); 
         Metadata metadata = new MetadataSources((org.hibernate.service.ServiceRegistry) serviceRegistry).getMetadataBuilder().build();
		 sessionFactory= metadata.getSessionFactoryBuilder().build(); 
		 session = sessionFactory.openSession();
	 
 }
	@Override
	public hotel gethotelById(int idh) {
    Query q=this.session.createQuery("select h from hotel where h.getId()=:id");
    q.setParameter("id", idh);
    hotel h =(hotel) q.getSingleResult();
    return null;
	}

	@Override
	public List<hotel> GetAllhotel() {
         Query q=this.session.createQuery("select h from hotel h");
         List<hotel> lh=q.getResultList();
		return null;
	}

	@Override
	public List<Chambre> GetChByhotel(hotel h) {
         Query q=this.session.createQuery("select ch from chambre ch where ch.gethotel().getId()=id");
         q.setParameter("id",h.getId());
         List<Chambre> lch=q.getResultList();
		return null;
	}

	@Override
	public void add(Chambre ch) {
 this.session.getTransaction().begin();
 this.session.save(ch);
 this.session.getTransaction().commit();
		
	}

	
	

}
