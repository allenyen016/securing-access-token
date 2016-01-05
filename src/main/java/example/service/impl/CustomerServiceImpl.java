package example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.ToolUtils.ToolUtil;
import example.pojo.Customer;
import example.service.CustomerService;
import example.service.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public int init() {

		customerRepository.deleteAll();
		customerRepository.save(new Customer((long) 1, "Allen", "Yen"));
		customerRepository.save(new Customer((long) 2, "Rcoko", "Tseng"));
		customerRepository.save(new Customer((long) 3, "Sandra", "Wei"));

		List<Customer> customers = (List<Customer>) customerRepository.findAll();

		return customers.size();
	}

	@Override
	public List<Customer> list() {

		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll((List<Customer>) customerRepository.findAll());

		return customers;
	}

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findOne(id);
	}

	@Override
	public Customer add(Customer customer) {

		String firstName = "addFirstName";
		String lastName = "addLastName";

		customer = customerRepository.save(customer);

		return customer;
	}

	@Override
	public boolean delete(Long id) {

		boolean flag = false;

		if (customerRepository.exists(id)) {
			customerRepository.delete(id);
			flag = true;
		}
		return flag;
	}

	@Override
	public Customer update(Customer customer) {


			customer = customerRepository.save(customer);

		return customer;
	}

}
