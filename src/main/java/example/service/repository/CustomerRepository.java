package example.service.repository;

import org.springframework.data.repository.CrudRepository;

import example.pojo.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
