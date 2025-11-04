package basics;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class QueryParametersTest {

  @Test
  public void queryParameter() {
    RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1";

    String title = given()
        .queryParam("ISBN", "9781449325862")
    .when()
        .get("/Book")
        .jsonPath()
        .getString("title");

    System.out.println("The book title is - " + title);
  }
}
