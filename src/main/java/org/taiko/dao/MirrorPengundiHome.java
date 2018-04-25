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
import org.taiko.entity.MirrorPengundi;
import org.taiko.entity.Pengundi;

/**
 * Home object for domain model class MirrorPengundi.
 * @see org.taiko.dao.MirrorPengundi
 * @author Hibernate Tools
 */

@Component
public class MirrorPengundiHome {

	private static final Log log = LogFactory.getLog(MirrorPengundiHome.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory( "postgres" );
	

	public void persist(MirrorPengundi transientInstance) {
		log.debug("persisting MirrorPengundi instance");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(transientInstance);
			em.getTransaction().commit();
			em.close();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MirrorPengundi persistentInstance) {
		log.debug("removing MirrorPengundi instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MirrorPengundi merge(MirrorPengundi detachedInstance) {
		log.debug("merging MirrorPengundi instance");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			MirrorPengundi result = em.merge(detachedInstance);
			em.getTransaction().commit();
			em.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MirrorPengundi findById(String id) {
		log.debug("getting MirrorPengundi instance with id: " + id);
		try {
			MirrorPengundi instance = entityManager.find(MirrorPengundi.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public MirrorPengundi mergePengundiToMirrorPengundi(Pengundi p) {
		log.debug("merging MirrorPengundi instance");
		try {
			MirrorPengundi result = mergeMp(p);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	private MirrorPengundi mergeMp(Pengundi p) {
		MirrorPengundi mp = new MirrorPengundi();
		mp.setNoKp(p.getNoKp());
		mp.setNama(p.getNama());
		mp.setJantina(p.getJantina());
		mp.setDm(p.getDm());
		mp.setKodLokaliti(p.getKodLokaliti());
		mp.setLokaliti(p.getLokaliti());
		mp.setKumpUmur(p.getKumpUmur());
		mp.setKumpKaum(p.getKumpKaum());
		mp.setTelNo1(p.getTelNo1());
		mp.setTelNo2(p.getTelNo2());
		mp.setAlamat(p.getAlamat());
		mp.setAlamatSt4(p.getAlamatSt4());
		mp.setFlagMasuk(p.getFlagMasuk());
		mp.setFlagKeluar(p.getFlagKeluar());
		mp.setStatusPengundi(p.getStatusPengundi());
		mp.setStatusAlamat(p.getStatusAlamat());
		mp.setNegeri(p.getNegeri());
		return mp;
	}

	public void save(MirrorPengundi mp) {
		try {
//			mirrorPengundiRepo.save(mp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public List<MirrorPengundi> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<Pengundi> findAll() {
		
		 Query query = entityManager.createQuery("SELECT * FROM pengundi");
		 
		 List<Pengundi>
		 
		return 
	}*/
}
