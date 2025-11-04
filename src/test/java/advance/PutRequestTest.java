package advance;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PutRequestTest {

  String userId = "eb7b3516-8b0d-42d3-a903-e34912e9fc1a";
  String baseUrl = "https://demoqa.com";
  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im9uZSIsInBhc3N3b3JkIjoiIU9uZW9uZTEiLCJpYXQiOjE3NjIwOTU4MTh9.kmfc2Wbqwc6yREILOCc2Sqx_6I_SXXMaG7STeklbfHg";
  String isbn = "9781449325865";

  @Test
  public void updateBook2() {
    RestAssured.baseURI = baseUrl;

    given()
        .header("Authorization", "Bearer " + token)
        .header("Content-Type", "application/json")
        .body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}")
    .when()
        .put("/BookStore/v1/Books/9781449325862")
    .then()
        .log().all();
  }
}
