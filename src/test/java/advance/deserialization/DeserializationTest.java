package advance.deserialization;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DeserializationTest {

  @Test
  public void userRegistration() {
    RestAssured.baseURI = "https://demoqa.com";

    JSONObject requestParams = new JSONObject();
    requestParams.put("userName", "test_rest");
    requestParams.put("password", "rest@1235)F");

    HTTPResponse httpResponse = given()
        .header("Content-Type", "application/json")
        .body(requestParams.toJSONString())
    .when()
        .post("/Account/v1/User")
        .as(HTTPResponse.class);

    System.out.println("Operation code: " + httpResponse.code);
    System.out.println("Operation message: " + httpResponse.message);
  }
}
