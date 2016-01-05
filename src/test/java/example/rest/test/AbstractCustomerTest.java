package example.rest.test;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import example.service.repository.CustomerRepository;

public abstract class AbstractCustomerTest extends AbstractTest {

    @Autowired
    protected CustomerRepository customerRepository;

    @After
    public void cleanup() {
        customerRepository.deleteAll();
    }

}
