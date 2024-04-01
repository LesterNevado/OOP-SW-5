import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookDA {
    private HashMap<String, Author> authorMap;
    private HashMap<String, Book> bookMap;

    public BookDA() throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("Book.csv"));
        bookMap = new HashMap<>();

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
            bookMap.put(book.getIsbn(), book);
            
        }
        
        for (Map.Entry<String, Book> entryMap : bookMap.entrySet()) {
            System.out.println(entryMap.getKey() + " " + entryMap.getValue().getTitle());
            for (Map.Entry<String, Author> entryMap2 : entryMap.getValue().getAuthorMap().entrySet()) {
                System.out.println("\t" + entryMap2.getValue().getName() + " - " + entryMap2.getValue().getBio());
            }
            System.out.println();
        }
        
        input.close();

    }

}
