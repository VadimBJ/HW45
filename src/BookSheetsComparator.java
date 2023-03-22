import java.util.Comparator;

public class BookSheetsComparator implements Comparator<Book> {
  @Override
  public int compare(Book o1, Book o2) {
    if (o1.getSheets() - o2.getSheets() != 0) {
            return o2.getSheets()-o1.getSheets();
    }
    return o1.getTitle().compareTo(o1.getTitle());
  }
}
