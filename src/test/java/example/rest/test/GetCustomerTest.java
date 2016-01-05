package example.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import example.pojo.Customer;

public class GetCustomerTest extends AbstractCustomerTest {

    @Test
    public void testGetReturnCurrectResource() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        given().spec(authenticatedRequest()).spec(halJsonRequest()).when().get("/customer/{id}", customer.getId()).then().statusCode(200)
                .body("firstName", equalTo(customer.getFirstName()))
        		.body("lastName", equalTo(customer.getLastName()));
    }

    @Test
    public void testGetNonAuth() {

    	Customer customer = customerRepository.save(new Customer("Allen", "Yen"));
    	
        given().spec(halJsonRequest())
        .when()
          .get("/customer/{id}", customer.getId())
        .then()
          .statusCode(401)
          .body("error", equalTo("Unauthorized"));
    }

}
