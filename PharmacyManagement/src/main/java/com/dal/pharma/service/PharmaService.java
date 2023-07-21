package com.dal.pharma.service;

import java.util.List;

import com.dal.pharma.entity.CustomerInfo;
import com.dal.pharma.entity.MedInfo;
import com.dal.pharma.entity.PharmaLogin;
import com.dal.pharma.entity.SalesInfo;


public interface PharmaService {
	
	//MedInfo Table Methods

	public MedInfo addMedicine(MedInfo medicine);		// Add a new medicine to the repository and return the saved medicine.
	public MedInfo editMedicine(MedInfo medicine);		// Edit/update an existing medicine in the repository and return the updated medicine.
	public void deleteMedicine(int medId);				// Delete a medicine from the repository based on the provided medicine ID.
	public MedInfo findMedicine(long medId);            // Find and return a medicine from the repository based on the provided medicine ID.
	public List<MedInfo> viewAvailability();            // Retrieve and return a list of all available medicines from the repository.
	
	//CustomerInfo Table Methods
	
	public CustomerInfo addCustomer(CustomerInfo customer);		// Add a new customer to the repository and return the saved customer.
	public CustomerInfo editCustomer(CustomerInfo customer);	// Edit/update an existing customer in the repository and return the updated customer.
	public void removeCustomer(long custId);					// Remove/delete a customer from the repository based on the provided customer ID.
	public CustomerInfo findCustomer(long Id);                	// Find and return a customer from the repository based on the provided customer ID.
	public List<CustomerInfo> viewCustomers();                 	// Retrieve and return a list of all customers from the repository.

	//SalesInfo Table Methods

	public SalesInfo addSale(SalesInfo sale);		// Add a new sale to the repository and return the saved sale.
	public SalesInfo findSale(long Id);             // Find and return a sale from the repository based on the provided sale ID.
	public List<SalesInfo> viewSales();				// Retrieve and return a list of all sales from the repository.
	public List<SalesInfo> sortSalesByDate();		// Sort the sales by date in ascending order and return the sorted list of sales.

	//pharmalogin credentials

	public PharmaLogin addPharmauser(PharmaLogin pharmauser);	// Add a new pharma user to the repository and return the saved pharma user.
}
