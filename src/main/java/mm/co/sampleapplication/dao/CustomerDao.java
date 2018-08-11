package mm.co.sampleapplication.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mm.co.sampleapplication.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long>{
		
	public List<Customer> findById(Integer id);
	
	public List<Customer> findByStatus(String status);

	public List<Customer> findAll();
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public List<Customer> search(String searchObj);
}
