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
public class PharmaLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pharmaId;

	@Column(nullable = false)
	private String pharmauser;
	
	@Column(nullable = false)
	private String pharmapass;

}
