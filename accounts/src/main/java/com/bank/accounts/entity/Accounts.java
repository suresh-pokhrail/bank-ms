package com.bank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Getter
@Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity {

	@Id
	@Column(name = "account_number")
	private long accountNumber;
	
	@Column(name = "customer_id")
	private long custId;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "branch")
	private String branch;

	@Column(name = "branch_address")
	private String branchAddress;
	
}
