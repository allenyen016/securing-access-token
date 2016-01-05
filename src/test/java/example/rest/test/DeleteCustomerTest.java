package example.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import example.pojo.Customer;

public class DeleteCustomerTest extends AbstractCustomerTest {

    @Test
    public void testDeleteOkReturn200Status() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        given().spec(authenticatedRequest()).when().delete("/customer/{id}", customer.getId()).then()
                .statusCode(200);
    }
    
    @Test
    public void testDeleteFailReturn204Status() {


        given().spec(authenticatedRequest()).when().delete("/customer/99").then()
                .statusCode(204);
    }

    @Test
    public void testDeleteNonAuth() {

        given()
        .when()
          .delete("/customers/1")
        .then()
          .statusCode(401)
          .body("error", equalTo("Unauthorized"));
    }

}
