package advance;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class AuthenticationTest {

  @Test
  public void getUserData() {
    given()
        .auth().basic("postman", "password")
    .when()
        .get("https://postman-echo.com/basic-auth")
    .then()
        .log().all();
  }

  @Test
  public void getUserData2() {
    given()
        .auth().preemptive().basic("postman", "password")
    .when()
        .get("https://postman-echo.com/basic-auth")
    .then()
        .log().all();
  }
}

//    given().auth().digest("your username", "your password").get("your end point URL")
//    given().auth().form("your username", "your password").post("your end point URL")
//    given().auth().form("your username", "your password", new FormAuthConfig("/perform_signIn","user","password"))
//    given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).get("your end point URL")
//    given().auth().oauth2("Access token").get("your end point URL")
