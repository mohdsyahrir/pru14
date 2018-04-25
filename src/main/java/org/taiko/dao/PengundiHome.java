package org.taiko.dao;
// Generated Apr 21, 2018 12:15:22 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.taiko.entity.Pengundi;

/**
 * Home object for domain model class Pengundi.
 * @see org.taiko.dao.Pengundi
 * @author Hibernate Tools
 */
@Component
public class PengundiHome {

	private static final Log log = LogFactory.getLog(PengundiHome.class);
	

	@PersistenceContext
	private EntityManager entityManager;
	
	private EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory( "postgres" );

	public void persist(Pengundi transientInstance) {
		log.debug("persisting Pengundi instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(transientInstance);
			entityManager.getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Pengundi persistentInstance) {
		log.debug("removing Pengundi instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Pengundi merge(Pengundi detachedInstance) {
		log.debug("merging Pengundi instance");
		try {
			Pengundi result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pengundi findById(String id) {
		log.debug("getting Pengundi instance with id: " + id);
		try {
			Pengundi instance = entityManager.find(Pengundi.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Pengundi> findAll() {
		entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from org.taiko.entity.Pengundi", Pengundi.class);
		 List<Pengundi> list = query.getResultList();
		return list;
	}
}
