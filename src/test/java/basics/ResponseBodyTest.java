package basics;

import static io.restassured.RestAssured.when;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResponseBodyTest {

  @Test
  public void WeatherMessageBody() {
    RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
    Response response = when().get("/Hyderabad");

    ResponseBody body = response.getBody();

    System.out.println("Response Body is: " + body.asString());
  }

  @Test
  public void WeatherMessageBody2() {
    RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
    Response response = when().get("/Hyderabad");

    ResponseBody body = response.getBody();

    String bodyAsString = body.asString();
    Assert.assertTrue(bodyAsString.contains("Hyderabad"));
  }

  @Test
  public void VerifyCityInJsonResponse() {
    RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
    String city = when()
        .get("/Hyderabad")
        .jsonPath()
        .get("City");

    System.out.println("City received from Response " + city);

    Assert.assertEquals(city, "Hyderabad");
  }
}
