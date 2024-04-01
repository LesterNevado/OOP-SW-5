import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA {
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }

    public AuthorDA(String authorName) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("Author.csv"));
        authorMap = new HashMap<>();

        while (input.hasNextLine()) {

            String authorRow = input.nextLine();
            String[] authorRowSpecific = new String[2];
            authorRowSpecific = authorRow.split(",");
 
            if(authorName.equals(authorRowSpecific[0])){
                Author author = new Author();
                author.setName(authorRowSpecific[0].trim());
                author.setBio(authorRowSpecific[1].trim());

                authorMap.put(author.getName(), author);
            }
            
        }
        input.close();
        
    }
    
}
