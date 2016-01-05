package example.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import example.pojo.Customer;

public class ListCustomerTest extends AbstractCustomerTest {

    @Test
    public void testListReturnOkAndCorrectSize() {

        customerRepository.save(new Customer("Allen", "Yen"));
        customerRepository.save(new Customer("Rocko", "Tseng"));
        customerRepository.save(new Customer("kevin", "hup"));
        
        Customer[] returnedArtworks = given().spec(authenticatedRequest()).spec(halJsonRequest()).when().get("/customer/list").getBody().as(Customer[].class);
        assertThat(returnedArtworks, arrayWithSize(3));
        given().spec(authenticatedRequest()).spec(halJsonRequest()).when().get("/customer/list").then().statusCode(200);
      
    }
    
    
    @Test
    public void testListNonAuth() {
        
        given()
        .when()
          .get("/customer/list")
        .then().statusCode(401)
          .body("error", equalTo("Unauthorized"));
      
    }

}
