import java.util.Objects;

public class Book implements Comparable<Book> {
  private String title;
  private String author;
  private int sheets;

  public Book(String title, String author, int sheets) {
    setTitle(title);
    setAuthor(author);
    setSheets(sheets);
  }

  @Override
  public String toString() {
    return String.format("%s \"%s\" (%d стр.)", author, title, sheets);
  }

  @Override
  public int compareTo(Book other) {
    if (!Objects.equals(this.author, other.author)) {
      return this.author.compareTo(other.author);
    }
    return this.title.compareTo(other.title);
  }

  public void setTitle(String title) {
    if (title == null || title.equals("")) {
      throw new IllegalArgumentException("Поле 'Название' не может быть пустым!");
    }
    this.title = title;
  }

  public void setAuthor(String author) {
    if (author == null || author.equals("")) {
      throw new IllegalArgumentException("Поле 'Автор' не может быть пустым!");
    }
    this.author = author;
  }

  public void setSheets(int sheets) {
    if (sheets < 1) {
      throw new IllegalArgumentException("Неверное количество страниц: " + sheets);
    }
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
