package advance.deserialization;

import static io.restassured.RestAssured.when;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeserializeJSONArrayToJAVAArrayTest {

  @Test
  public void jsonArrayToJavaArray() {

    RestAssured.baseURI = "https://bookstore.demoqa.com/BookStore/v1/Books";

    Book[] books = when()
        .get()
        .jsonPath()
        .getObject("books", Book[].class);

    for(int i = 0; i < books.length; i++) {
      System.out.println(i + 1);
      System.out.println(books[i].isbn);
      System.out.println(books[i].title);
      System.out.println(books[i].subTitle);
      System.out.println(books[i].author);
      System.out.println(books[i].publish_date);
      System.out.println(books[i].publisher);
      System.out.println(books[i].pages);
      System.out.println(books[i].description);
      System.out.println(books[i].website);
      System.out.println("");
      System.out.println("");
    }
  }
}
