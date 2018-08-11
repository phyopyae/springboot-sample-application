package mm.co.sampleapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.co.sampleapplication.dao.CustomerDaoImpl;
import mm.co.sampleapplication.entity.Customer;

@Service
public class CustomerServiceImpl {

	@Autowired
	CustomerDaoImpl dao;
		
	public List<Customer> findById(Integer id){
		return dao.findById(id);
	};
	
	public List<Customer> findByStatus(String status){
		return dao.findByStatus(status);
	};	
	
	public List<Customer> findAll(){
		return dao.findAll();
	};
	
	public void addCustomer(Customer customer){
		dao.addCustomer(customer);
	};
	
	public void updateCustomer(Customer customer){
		dao.updateCustomer(customer);
	};
	
	public List<Customer> search(String searchObj){
		return dao.search(searchObj);
	};
}
