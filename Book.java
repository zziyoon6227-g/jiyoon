public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int idValue, String titleValue, String authorValue) {
        id = idValue;
        title = titleValue;
        author = authorValue;
    }
    
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String toFileString() {
        return "ID: " + id + ", 제목: " + title + ", 저자: " + author;
    }
}
