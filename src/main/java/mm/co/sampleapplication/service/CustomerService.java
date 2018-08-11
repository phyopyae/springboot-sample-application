package mm.co.sampleapplication.service;

import java.io.Serializable;
import java.util.List;

import mm.co.sampleapplication.entity.Customer;

public interface CustomerService extends Serializable{

	public Customer findById(Integer id);

	public List<Customer> findAll();
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public List<Customer> search(String searchObj);
}
