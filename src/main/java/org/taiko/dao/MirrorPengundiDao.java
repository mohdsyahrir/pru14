package org.taiko.dao;

import org.springframework.stereotype.Repository;
import org.taiko.entity.MirrorPengundi;

@Repository
public interface MirrorPengundiDao {

	void save(MirrorPengundi mp);

}
