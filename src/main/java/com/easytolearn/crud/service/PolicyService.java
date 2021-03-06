package com.easytolearn.crud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.easytolearn.crud.entity.PolicyEntity;
import com.easytolearn.crud.exception.PolicyNotFoundException;

@Component
public interface PolicyService {
	
	public List<PolicyEntity> getAllPolicies();
	
	public PolicyEntity getPolicyByNumber(Long policyNumber) throws PolicyNotFoundException;
	
	public PolicyEntity createPolicy(PolicyEntity entity);
	
	public PolicyEntity updtePolicy(PolicyEntity entity) throws PolicyNotFoundException;
	
	public void deletePolicyById(Long policyNumber) throws PolicyNotFoundException;

}
