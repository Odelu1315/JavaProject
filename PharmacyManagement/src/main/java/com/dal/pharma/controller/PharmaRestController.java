package com.dal.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dal.pharma.entity.CustomerInfo;
import com.dal.pharma.entity.MedInfo;
import com.dal.pharma.entity.PharmaLogin;
import com.dal.pharma.entity.SalesInfo;
import com.dal.pharma.service.PharmaService;

@RestController
public class PharmaRestController {
	@Autowired
	PharmaService pharmaService;

	@GetMapping("/welcome")
	public static String hello() {
		return "Hi all";
	}

	@PostMapping("/addMedicine")
	public MedInfo addMedicine(@RequestBody MedInfo medicine) {
		return pharmaService.addMedicine(medicine);
	}

	@PutMapping("/editMedicine")
	public MedInfo editMedicine(@RequestBody MedInfo medicine) {
		return pharmaService.editMedicine(medicine);
	}

	@DeleteMapping("/deleteMedInfo/{medId}")
	public void deleteMedicine(@PathVariable("medId") int medId) {
		pharmaService.deleteMedicine(medId);
	}

	@GetMapping("/findMedicine/{medId}")
	public MedInfo findMedicine(@PathVariable("medId") long medId) {
		return pharmaService.findMedicine(medId);

	}
	@PreAuthorize("hasAuthority('odelu')")
	@GetMapping("/viewMedicine")
	public List<MedInfo> viewAvailability() {
		return pharmaService.viewAvailability();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PreAuthorize("hasAuthority('odelu')")
	@PostMapping("/addCustomer")
	public CustomerInfo addCustomer(@RequestBody CustomerInfo customer) {
		return pharmaService.addCustomer(customer);
	}

	@PutMapping("/editCustomer")
	public CustomerInfo editCustomer(@RequestBody CustomerInfo customer) {
		return pharmaService.editCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomerInfo/{custId}")
	public void removeCustomer(@PathVariable("custId") long custId) {
		pharmaService.removeCustomer(custId);
	}

	@GetMapping("/findCustomer/{custId}")
	public CustomerInfo findCustomer(@PathVariable("custId") long custId) {
		return pharmaService.findCustomer(custId);
	}

	@PreAuthorize("hasAuthority('odelu')")
	@GetMapping("/viewCustomer")
	public List<CustomerInfo> viewCustomers() {
		return pharmaService.viewCustomers();
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/addSale")
	public SalesInfo addsale(@RequestBody SalesInfo sale) {
		return pharmaService.addSale(sale);
	}

	@GetMapping("/findSale/{saleId}")
	public SalesInfo findSale(@PathVariable("saleId") long saleId) {
		return pharmaService.findSale(saleId);
	}

	@GetMapping("/viewSales")
	public List<SalesInfo> viewSales() {
		return pharmaService.viewSales();
	}

	@GetMapping("/sortSalesByDate")
	public List<SalesInfo> getSortedSalesByDate() {
		return pharmaService.sortSalesByDate();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/addPharmauser")
	public PharmaLogin addPharmauser(@RequestBody PharmaLogin pharmauser) {
		return pharmaService.addPharmauser(pharmauser);
	}

}
