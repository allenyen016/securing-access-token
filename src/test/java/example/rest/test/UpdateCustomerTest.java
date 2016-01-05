package example.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import example.pojo.Customer;

public class UpdateCustomerTest extends AbstractCustomerTest {

    @Test
    public void testUpdateReturnCurrectResource() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));
        
       
        Customer body = new Customer(customer.getId(),"Rocko", "Tseng");

        
        
        given().spec(authenticatedRequest()).spec(halJsonRequest()).body(body)
          .when().put("/customer/")
          .then()
            .statusCode(200)
            .body("firstName", equalTo(body.getFirstName()))
            .body("lastName", equalTo(body.getLastName()));
    }

    @Test
    public void testUpdateNonAuth() {

        Customer customer = new Customer("Allen", "Yen");

        given().body(customer)
         .when()
          .put("/customer/")
         .then()
           .statusCode(401)
           .body("error", equalTo("Unauthorized"));
    }

}
