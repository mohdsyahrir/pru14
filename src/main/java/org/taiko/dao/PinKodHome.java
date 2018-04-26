package org.taiko.dao;
// Generated Apr 25, 2018 12:39:29 AM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.taiko.entity.PinKod;

/**
 * Home object for domain model class PinKod.
 * @see org.taiko.dao.PinKod
 * @author Hibernate Tools
 */
@Component
public class PinKodHome {

	private static final Log log = LogFactory.getLog(PinKodHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PinKod transientInstance) {
		log.debug("persisting PinKod instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PinKod persistentInstance) {
		log.debug("removing PinKod instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PinKod merge(PinKod detachedInstance) {
		log.debug("merging PinKod instance");
		try {
			PinKod result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PinKod findById(int id) {
		log.debug("getting PinKod instance with id: " + id);
		try {
			PinKod instance = entityManager.find(PinKod.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
