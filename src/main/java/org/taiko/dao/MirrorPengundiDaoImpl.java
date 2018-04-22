package org.taiko.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.taiko.entity.MirrorPengundi;

@Transactional
public class MirrorPengundiDaoImpl implements MirrorPengundiDao {

	@PersistenceContext
	 public EntityManager entityManager;
	
	@Override
	public void save(MirrorPengundi mp) {
		// TODO Auto-generated method stub
		entityManager.persist(mp);
	}

}
