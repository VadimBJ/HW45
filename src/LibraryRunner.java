import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryRunner {
  public static void main(String[] args) throws IOException {
    File inputFile = new File("res/books.csv");
    List<Book> bookList = readFile(inputFile);
    System.out.println("Доступные книги:");
    for (int i = 0; i < bookList.size(); i++) {
      System.out.print((i+1)+". "+ bookList.get(i));

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
    return bookList;
  }
}