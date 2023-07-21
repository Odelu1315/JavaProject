package com.dal.pharma.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.pharma.entity.CustomerInfo;

import jakarta.transaction.Transactional;


@Repository
public interface CustomerInfoRepo extends CrudRepository<CustomerInfo, Long> {
	@Transactional
	public void deleteBycustId(long custId);

}
