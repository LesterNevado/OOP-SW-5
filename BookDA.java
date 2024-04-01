import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookDA {
    private HashMap<String, Author> authorMap;

    public BookDA() throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("Book.csv"));

        while (input.hasNext()) {
            authorMap = new HashMap<>();

            String bookRow = input.nextLine();
            String[] bookRowSpecific = new String[3];
            bookRowSpecific = bookRow.split(",");

            Book book = new Book();
            book.setIsbn(bookRowSpecific[0].trim());
            book.setTitle(bookRowSpecific[1].trim());
            book.setAuthorName(bookRowSpecific[2].trim());

            AuthorDA authorDA = new AuthorDA(book.getAuthorName());
            book.setAuthorMap(authorDA.getAuthorMap());
            
            print(book);
        }
        input.close();

    }

    private void print(Book book) {
        System.out.println(book.getIsbn() + " " + book.getTitle());
        for (Map.Entry<String, Author> entryMap : book.getAuthorMap().entrySet()) {
            System.out.println("\t" + entryMap.getValue().getName() + " - " + entryMap.getValue().getBio());
        }
        System.out.println();
    }

}
