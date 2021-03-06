package com.easytolearn.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytolearn.crud.entity.PolicyEntity;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyEntity, Long>{

}
