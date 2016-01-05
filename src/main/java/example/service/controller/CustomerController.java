package example.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.pojo.Customer;
import example.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerServiceImpl;

	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> list() {

		List<Customer> customers = customerServiceImpl.list();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Customer> add(@RequestBody Customer requestBody) {

		Customer customer = customerServiceImpl.add(requestBody);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Long id) {

		HttpStatus httpStatus = HttpStatus.NO_CONTENT;

		if (customerServiceImpl.delete(id)) {
			httpStatus = HttpStatus.OK;
		}

		return new ResponseEntity(httpStatus);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> findOne(@PathVariable Long id) {

		Customer customer = customerServiceImpl.findOne(id);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Customer> update(@RequestBody Customer requestBody) {

		Customer customer = customerServiceImpl.update(requestBody);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
