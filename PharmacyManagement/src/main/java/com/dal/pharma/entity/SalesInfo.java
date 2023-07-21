package com.dal.pharma.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class SalesInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salesId;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerInfo customer;

	@Column(nullable = false)
	private long medId;
	@Column(nullable = false)
	private Date saleDate;
	@Column(nullable = false)
	private int saleQty;
	@Column(nullable = false)
	private int saleValue;
	@Column(nullable = false)
	private String status;
}
