package example.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import example.pojo.Customer;

public class CreateCustomerTest extends AbstractCustomerTest {

    @Test
    public void testCreateReturnCurrectResource() {

    	 Customer customer = new Customer("Allen", "Yen");

        given().spec(authenticatedRequest()).spec(halJsonRequest()).body(customer)
         .when()
           .post("/customer/")
         .then()
           .statusCode(200)
           .body("firstName", equalTo(customer.getFirstName()))
           .body("lastName", equalTo(customer.getLastName()));
    }
    
    @Test
    public void testCreateNonAuth() {

        Customer customer = new Customer("Allen", "Yen");

        given().body(customer)
         .when()
           .post("/customer/")
         .then()
           .statusCode(401)
           .body("error", equalTo("Unauthorized"));
    }

}
