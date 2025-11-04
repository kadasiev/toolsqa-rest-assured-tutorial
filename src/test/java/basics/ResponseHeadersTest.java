package basics;

import static io.restassured.RestAssured.when;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResponseHeadersTest {

  @Test
  public void IteratingHeaders() {
    Headers headers = when().get("https://demoqa.com/BookStore/v1/Books").getHeaders();

    for (Header header : headers) {
      System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
    }
  }

  @Test
  public void GetBookHeaders() {
    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
    Response response = when().get();

    System.out.println("Content-Type value: " + response.getHeader("Content-Type"));
    System.out.println("Server value: " + response.getHeader("Server"));
    System.out.println("Content-Encoding: " + response.getHeader("Content-Encoding"));
  }

  @Test
  public void ValidateBookHeaders() {
    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
    Response response = when().get("");

    Assert.assertEquals(response.getHeader("Content-Type") /* actual value */,
        "application/json; charset=utf-8" /* expected value */);

    Assert.assertEquals(response.getHeader("Server") /* actual value */,
        "nginx/1.17.10 (Ubuntu)" /* expected value */);
  }
}
