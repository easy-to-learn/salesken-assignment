package com.easytolearn.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytolearn.crud.entity.PolicyEntity;
import com.easytolearn.crud.exception.PolicyNotFoundException;
import com.easytolearn.crud.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	@GetMapping
	public ResponseEntity<List<PolicyEntity>> getAllPolicies(){
		List<PolicyEntity> policiesList = policyService.getAllPolicies();
		return new ResponseEntity<List<PolicyEntity>>(policiesList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{policyNumber}")
    public ResponseEntity<PolicyEntity> getpolicyByNumber(@PathVariable("policyNumber") Long policyNumber)
                                                    throws PolicyNotFoundException {
		PolicyEntity entity = policyService.getPolicyByNumber(policyNumber);
        return new ResponseEntity<PolicyEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	
	@PostMapping("/createPolicy")
	public ResponseEntity<PolicyEntity> createPolicy(@RequestBody PolicyEntity entity) throws PolicyNotFoundException{
		PolicyEntity policy = policyService.createPolicy(entity);
		return new ResponseEntity<PolicyEntity>(policy, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/updatePolicy")
	public ResponseEntity<PolicyEntity> updatePolicy(@RequestBody PolicyEntity entity) throws PolicyNotFoundException {
		PolicyEntity updated = policyService.updtePolicy(entity);
		return new ResponseEntity<PolicyEntity>(updated,new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{policyNumber}")
	public ResponseEntity<String> deletePolicy(@PathVariable("policyNumber") Long policy) throws PolicyNotFoundException{	
		policyService.deletePolicyById(policy);
		return new ResponseEntity<String>("Policy Deleted", new HttpHeaders(), HttpStatus.OK);
	}
	
}
