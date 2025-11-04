package advance;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequestTest {

  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im9uZSIsInBhc3N3b3JkIjoiIU9uZW9uZTEiLCJpYXQiOjE3NjIwOTU4MTh9.kmfc2Wbqwc6yREILOCc2Sqx_6I_SXXMaG7STeklbfHg";

  @Test
  public void userRegistration2() {
    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

    Response response = given()
//        .auth().preemptive().basic("one", "!Oneone1")
        .auth().oauth2(token)
        .header("Content-Type", "application/json")
        .body("{\n"
            + "  \"userId\": \"eb7b3516-8b0d-42d3-a903-e34912e9fc1a\",\n"
            + "  \"collectionOfIsbns\": [\n"
            + "    {\n"
            + "      \"isbn\": \"9781449325862\"\n"
            + "    }\n"
            + "  ]\n"
            + "}")
    .when()
        .post();

    System.out.println(response.getStatusLine());
    System.out.println(response.getBody().asPrettyString());
  }

  @Test
  public void userRegistration3() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("userId", "7b3b8335-cd15-472e-8124-6d5896d95393");
    requestParams.put("isbn", "9781449325862");

    System.out.println("The status received: " + requestParams.toJSONString());
  }
}
