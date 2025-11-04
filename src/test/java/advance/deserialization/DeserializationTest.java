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

    JSONResponse JSONResponse = given()
        .header("Content-Type", "application/json")
        .body(requestParams.toJSONString())
    .when()
        .post("/Account/v1/User")
        .as(JSONResponse.class);

    System.out.println("Operation code: " + JSONResponse.code);
    System.out.println("Operation message: " + JSONResponse.message);
  }
}
