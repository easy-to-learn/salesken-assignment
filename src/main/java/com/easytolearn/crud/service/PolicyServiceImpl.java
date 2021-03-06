package com.easytolearn.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easytolearn.crud.entity.PolicyEntity;
import com.easytolearn.crud.exception.PolicyNotFoundException;
import com.easytolearn.crud.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	PolicyRepository repository;
	
	@Override
	public List<PolicyEntity> getAllPolicies() {

		List<PolicyEntity> policyList = repository.findAll();
		
		if(policyList.size() > 0) {
			return policyList;
		} else {
			return new ArrayList<PolicyEntity>();
		}
	}

	@Override
	public PolicyEntity getPolicyByNumber(Long policyNumber) throws PolicyNotFoundException {
		Optional<PolicyEntity> policy = repository.findById(policyNumber);
        
        if(policy.isPresent()) {
            return policy.get();
        } else {
            throw new PolicyNotFoundException("No employee record exist for given policy");
        }
	}

	@Override
	public PolicyEntity createPolicy(PolicyEntity entity) {
		entity = repository.save(entity);
		return entity;
	}

	@Override
	public PolicyEntity updtePolicy(PolicyEntity entity) throws PolicyNotFoundException {
		Optional<PolicyEntity> policy = repository.findById(entity.getPolicyNumber());
		
		if(policy.isPresent()) {
		  repository.save(entity);	
		}else {
			throw new PolicyNotFoundException("Policy number not found");
		}
		return entity;
	}

	@Override
	public void deletePolicyById(Long policy) throws PolicyNotFoundException {
		
		Optional<PolicyEntity> entity = repository.findById(policy);
		
		if(entity.isPresent()) {
		  repository.deleteById(policy);	
		}else {
			throw new PolicyNotFoundException("Policy number not found to delete");
		}
	}

}
