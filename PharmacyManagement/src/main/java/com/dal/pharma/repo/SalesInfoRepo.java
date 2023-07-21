package com.dal.pharma.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.pharma.entity.SalesInfo;

@Repository
public interface SalesInfoRepo extends CrudRepository<SalesInfo, Long> {

}
