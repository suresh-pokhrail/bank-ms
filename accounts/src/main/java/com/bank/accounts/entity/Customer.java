package com.bank.accounts.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer")
@Getter
@Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
	private long id;
	
	@Column(name = "name")
	private String name; 
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "gender")
	private String gender; 
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "ssno")
	private String ssno;
	
	@Column(name = "dob", columnDefinition = "DATE")
	private Date dob;      
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private String status;
	//status 0 = Admin , 1 = user, 2 = delete

}
