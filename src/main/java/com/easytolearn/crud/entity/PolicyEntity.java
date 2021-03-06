package com.easytolearn.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="Policy_Details")
public class PolicyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="policy_number")
	private Long policyNumber;
	
	@Column(name="first_name", nullable=false, length=200)
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email", nullable=false, length=200)
    private String email;
    
    @Column(name="phone_number", nullable=false, length=10)
    private int phoneNumber;
    
}
