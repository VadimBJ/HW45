import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class BookTitleComparatorTests {
  @Test
  public void BookTitleAuthorComparator() {
    Book book1 = new Book("Book1", "A", 5);
    Book book2 = new Book("Book2", "С", 5);
    Book book3 = new Book("Book2", "B", 25);
    Book book4 = new Book("Book2", "A", 15);
    Book book5 = new Book("Book2", " ", 35);
    Book book6 = new Book(" ", "B", 52);

    List<Book> actual = new ArrayList<>();
    actual.add(book1);
    actual.add(book2);
    actual.add(book3);
    actual.add(book4);
    actual.add(book5);
    actual.add(book6);

    List<Book> expected = new ArrayList<>();
    expected.add(book6);
    expected.add(book1);
    expected.add(book5);
    expected.add(book4);
    expected.add(book3);
    expected.add(book2);

    actual.sort(new BookTitleComparator());

    assertEquals(expected, actual);
  }

  @Test
  public void BookWithWrongPages() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Book("A", "B", -5));
  }

  @Test
  public void BookWithAuthorEmpty() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Book("A", "", 5));
  }

  @Test
  public void BookWithTitleEmpty() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Book("", "B", 5));
  }
}
