package example.service;

import java.util.List;

import example.pojo.Customer;


public interface CustomerService {

	public List<Customer> list();

	public Customer findOne(Long id);

	public Customer add(Customer customer);

	public boolean delete(Long id);

	public Customer update(Customer customer);

	public int init();
}
