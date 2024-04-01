import java.util.HashMap;

public class Book {
    private String isbn;
    private String title;
    private String authorName;
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }
    public void setAuthorMap(HashMap<String, Author> authorMap) {
        this.authorMap = authorMap;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
