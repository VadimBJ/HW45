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
    return String.format("""
        \"%s\"  %s (%d стр.)%n""", title,author,sheets);
  }

  @Override
  public int compareTo(Book other) {
    if (this.author != other.author) {
      return this.author.compareTo(other.author);
    }
    return this.title.compareTo(other.title);
  }
}
