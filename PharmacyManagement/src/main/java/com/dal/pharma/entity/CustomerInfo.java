package com.dal.pharma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long custId;
	@Column(nullable = false)
	private String custName;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private int phoneNo;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String status;
}
