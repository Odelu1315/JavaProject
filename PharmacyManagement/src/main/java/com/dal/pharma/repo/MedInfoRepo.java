package com.dal.pharma.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dal.pharma.entity.MedInfo;
import jakarta.transaction.Transactional;

@Repository
public interface MedInfoRepo extends CrudRepository<MedInfo, Long> {
	@Transactional
	public void deleteBymedId(int medId);

}
