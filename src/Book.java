import java.util.Objects;

public class Book implements Comparable<Book> {
  private String title;
  private String author;
  private int sheets;

  public Book(String title, String author, int sheets) {
    this.title = title;
    this.author = author;
    this.sheets = sheets;
  }

  @Override
  public String toString() {
    return String.format("%s \"%s\" (%d стр.)%n", author, title, sheets);
  }

  @Override
  public int compareTo(Book other) {
    if (!Objects.equals(this.author, other.author)) {
      return this.author.compareTo(other.author);
    }
    return this.title.compareTo(other.title);
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setSheets(int sheets) {
    this.sheets = sheets;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getSheets() {
    return sheets;
  }
}
