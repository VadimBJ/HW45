import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryRunner {
  public static void main(String[] args) throws IOException {
    File inputFile = new File("res/books.csv");
    List<Book> bookList = readFile(inputFile);
    bookPrint(bookList);
    System.out.println("\u001B[34m\n .... обычная сортировка ..... \u001B[0m");
    Collections.sort(bookList);
    bookPrint(bookList);
    System.out.println("\u001B[34m\n .... сортировка по названию ..... \u001B[0m");
    bookList.sort(new BookTitleComparator());
    bookPrint(bookList);
    System.out.println("\u001B[34m\n ... сортировка по убыванию количества страниц ... \u001B[0m");
    bookList.sort(new BookSheetsComparator());
    bookPrint(bookList);
  }

  public static void bookPrint(List<Book> bookList) {
    System.out.println("Доступные книги:");
    for (int i = 0; i < bookList.size(); i++) {
      System.out.printf("%2d. %s%n", (i + 1), bookList.get(i));
    }
  }

  public static List<Book> readFile(File inputFile) throws IOException {
    List<Book> bookList = new ArrayList<>();
    BufferedReader fr = new BufferedReader(new FileReader(inputFile));
    for (String line = fr.readLine(); line != null; line = fr.readLine()) {
      String[] lines = line.split(";");
      String title = lines[0];
      String author = lines[1];
      int sheets = Integer.parseInt(lines[2]);
      bookList.add(new Book(title, author, sheets));
    }
    fr.close();
    return bookList;
  }
}