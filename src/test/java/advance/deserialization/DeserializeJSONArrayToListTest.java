package advance.deserialization;

import static io.restassured.RestAssured.when;

import io.restassured.RestAssured;
import java.util.List;
import org.testng.annotations.Test;

public class DeserializeJSONArrayToListTest {

  @Test
  public void jsonToStringList() {
    RestAssured.baseURI = "https://bookstore.demoqa.com/BookStore/v1/Books";

    List<String> allBooks = when()
        .get()
        .jsonPath()
        .getList("books.title");

    for(String book : allBooks) {
      System.out.println("Book: " + book);
    }
  }

  @Test
  public void jsonToObjectList() {
    RestAssured.baseURI = "https://bookstore.demoqa.com/BookStore/v1/Books";

    List<Book> allBooks = when()
        .get()
        .jsonPath()
        .getList("books", Book.class);

    for(Book book : allBooks)
    {
      System.out.println("Book: " + book.title);
    }

    for(int i = 0; i < allBooks.size(); i++) {
      System.out.println(i + 1);
      System.out.println(allBooks.get(i).isbn);
      System.out.println(allBooks.get(i).title);
      System.out.println(allBooks.get(i).subTitle);
      System.out.println(allBooks.get(i).author);
      System.out.println(allBooks.get(i).publish_date);
      System.out.println(allBooks.get(i).publisher);
      System.out.println(allBooks.get(i).pages);
      System.out.println(allBooks.get(i).description);
      System.out.println(allBooks.get(i).website);
      System.out.println("");
      System.out.println("");
    }
  }
}
