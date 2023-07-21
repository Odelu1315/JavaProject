package com.dal.pharma.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dal.pharma.entity.CustomerInfo;
import com.dal.pharma.entity.MedInfo;
import com.dal.pharma.entity.PharmaLogin;
import com.dal.pharma.entity.SalesInfo;
import com.dal.pharma.repo.CustomerInfoRepo;
import com.dal.pharma.repo.MedInfoRepo;
import com.dal.pharma.repo.SalesInfoRepo;
import com.dal.pharma.repo.PharmaRepo;

@Service
public class PharmaServiceImpl implements PharmaService {

	@Autowired
	private MedInfoRepo medInfoRepo;
	@Autowired
	private CustomerInfoRepo customerInfoRepo;
	@Autowired
	SalesInfoRepo salesInfoRepo;
	@Autowired
	PharmaRepo pharmarepos;

	@Override
	public MedInfo addMedicine(MedInfo medicine) {
		return medInfoRepo.save(medicine);
	}
	
	// Add a new medicine to the repository and return the saved medicine.

	@Override
	public MedInfo editMedicine(MedInfo medicine) {
		return medInfoRepo.save(medicine);
	}
	
	// Edit/update an existing medicine in the repository and return the updated medicine.

	@Override
	public MedInfo findMedicine(long medId) {
		return medInfoRepo.findById(medId).get();
	}
	
	// Find and return a medicine from the repository based on the provided medicine ID.

	@Override
	public List<MedInfo> viewAvailability() {
		return (List<MedInfo>) medInfoRepo.findAll();
	}
	
	// Retrieve and return a list of all available medicines from the repository.

	@Override
	public void deleteMedicine(int medId) {
		medInfoRepo.deleteBymedId(medId);
	}
	
	// Delete a medicine from the repository based on the provided medicine ID.

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public CustomerInfo addCustomer(CustomerInfo customer) {
		return customerInfoRepo.save(customer);
	}
	
	// Add a new customer to the repository and return the saved customer.

	@Override
	public CustomerInfo editCustomer(CustomerInfo customer) {
		return customerInfoRepo.save(customer);
	}
	
	// Edit/update an existing customer in the repository and return the updated customer.

	@Override
	public void removeCustomer(long custId) {
		customerInfoRepo.deleteBycustId(custId);
	}
	
	// Remove/delete a customer from the repository based on the provided customer ID.

	@Override
	public CustomerInfo findCustomer(long Id) {
		return customerInfoRepo.findById(Id).get();
	}
	
	// Find and return a customer from the repository based on the provided customer ID.

	@Override
	public List<CustomerInfo> viewCustomers() {
		return (List<CustomerInfo>) customerInfoRepo.findAll();
	}
	
	// Retrieve and return a list of all customers from the repository.

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public SalesInfo addSale(SalesInfo sale) {
		return salesInfoRepo.save(sale);
	}
	
	// Add a new sale to the repository and return the saved sale.

	@Override
	public SalesInfo findSale(long Id) {
		return salesInfoRepo.findById(Id).get();
	}
	
	// Find and return a sale from the repository based on the provided sale ID.

	@Override
	public List<SalesInfo> viewSales() {
		return (List<SalesInfo>) salesInfoRepo.findAll();
	}
	
	// Retrieve and return a list of all sales from the repository.

	@Override
	public List<SalesInfo> sortSalesByDate() {
	    List<SalesInfo> allSales = (List<SalesInfo>) salesInfoRepo.findAll();

	    List<SalesInfo> sortedSales = allSales.stream()
	            .sorted(Comparator.comparing(SalesInfo::getSaleDate))
	            .collect(Collectors.toList());

	    return sortedSales;
	}
	
	// Sort the sales by date in ascending order and return the sorted list of sales.

	@Override
	public PharmaLogin addPharmauser(PharmaLogin pharmauser) {
		return pharmarepos.save(pharmauser);
	}
	
	// Add a new pharma user to the repository and return the saved pharma user.

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
