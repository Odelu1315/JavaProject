package com.dal.pharma.repo;

import org.springframework.data.repository.CrudRepository;

import com.dal.pharma.entity.PharmaLogin;

public interface PharmaRepo extends CrudRepository<PharmaLogin, Long > {
	PharmaLogin findBypharmauser(String pharmauser);
}
