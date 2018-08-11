package mm.co.sampleapplication.development;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mm.co.sampleapplication.entity.Customer;
import mm.co.sampleapplication.service.CustomerServiceImpl;

@RestController
@Transactional
public class CustomerController {

	@Autowired
	CustomerServiceImpl service;

	@RequestMapping({ "/", "/home" })
	public String hello(Model model) {
		return "home";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public Map<String, List<Customer>> list(Model model, String status) {
		List<Customer> customerList = new ArrayList<>();
		if (status == null) {
			customerList = service.findAll();
		} else if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("inactive")) {
			customerList = service.findByStatus(status.toUpperCase());
		}
		Map<String, List<Customer>> customerMap = new HashMap<>();
		customerMap.put("customer", customerList);
		return customerMap;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Map<String, Map<String, String>> customer) {
		Customer addCustomer = new Customer();
		if (customer != null) {
			Map<String, String> customerMap = customer.get("customer");
			if (customerMap != null) {
				addCustomer.setName(customerMap.get("name"));
				addCustomer.setMobile(customerMap.get("mobile"));
				addCustomer.setAddress(customerMap.get("address"));
				service.addCustomer(addCustomer);
			}
		}
	}

	@RequestMapping(value = "/customers/updates/{id}", method = RequestMethod.GET)
	public Map<String, List<Customer>> getUpdateCustomer(@PathVariable("id") Integer id) {
		List<Customer> customerList = service.findById(id);
		Map<String, List<Customer>> customerMap = new HashMap<>();
		customerMap.put("update", customerList);
		return customerMap;

	}

	@RequestMapping(value = "/update/updates", method = RequestMethod.POST)
	public void updateCustomer(@RequestBody Map<String, Map<String, String>> customerObj) {
		if (customerObj != null) {
			Map<String, String> customerUpdateMap = customerObj.get("update");
			int id = Integer.parseInt(customerUpdateMap.get("id"));
			List<Customer> customerList = service.findById(id);
			for (Customer customer : customerList) {
				customer.setName(customerUpdateMap.get("name"));
				customer.setMobile(customerUpdateMap.get("mobile"));
				customer.setAddress(customerUpdateMap.get("address"));
				customer.setStatus(customerUpdateMap.get("status"));
				service.updateCustomer(customer);
			}
		}

	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public Map<String, List<Customer>> getCustomerById(@PathVariable("id") Integer id) {
		List<Customer> customer = service.findById(id);
		Map<String, List<Customer>> customerMap = new HashMap<>();
		customerMap.put("customer", customer);
		return customerMap;
	}
	
	@RequestMapping(value = "/searches", method = RequestMethod.GET)
	public Map<String, List<Customer>> search(String search) {
		List<Customer> customerList = new ArrayList<>();
		if (search != null) {
			customerList = service.search(search);
		}
		Map<String, List<Customer>> customerMap = new HashMap<>();
		customerMap.put("customer", customerList);
		return customerMap;
	}

}
