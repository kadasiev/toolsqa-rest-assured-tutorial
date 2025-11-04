package basics;

import static io.restassured.RestAssured.when;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetRequestTest {

  @Test
  public void GetBooksDetails() {
    Response response = when()
        .get("https://demoqa.com/BookStore/v1/Books");

    System.out.println("Status received => " + response.getStatusLine());
    System.out.println("Response=>" + response.asPrettyString());
  }
}
