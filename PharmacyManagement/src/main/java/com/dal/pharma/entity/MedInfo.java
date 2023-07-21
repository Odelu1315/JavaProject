package com.dal.pharma.entity;

import java.util.Date;

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
public class MedInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long medId;
	@Column(nullable = false)
	private String medName;
	@Column(nullable = false)
	private String manufacturer;
	@Column(nullable = false)
	private Date expiryDate;
	@Column(nullable = false)
	private Double unitPrice;
	@Column(nullable = false)
	private int availabeQty;
	@Column(nullable = false)
	private String status;
}
