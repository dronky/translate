import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sinky on 23.01.2017.
 */
public class FileWrite {
    List<String> words = Arrays.asList();
    String path = "words.txt";

    public FileWrite(String path) {
        this.path = path;
    }

    public void write(String toTrans, String translated) {
        toTrans=toTrans.toLowerCase();
        toTrans=toTrans.replaceAll("\\s+","");
              try (FileWriter fw = new FileWriter(path, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
                  if (!checkWord(toTrans))
                      out.println(toTrans+" "+translated);
                  else System.out.println("word already exist");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    private void readInList() throws IOException {
        Path file = Paths.get(path);
        words = Files.readAllLines(file);
    }

    private boolean checkWord(String word) throws IOException {
        boolean found = false;
        readInList();
        for (String str : words)
            if (str.toLowerCase().contains(word))
                found = true;
        return found;
    }

}
