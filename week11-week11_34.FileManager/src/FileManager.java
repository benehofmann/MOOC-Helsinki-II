
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private Scanner reader;

    public List<String> read(String file) throws FileNotFoundException {
        reader = new Scanner(new FileInputStream(file));
        ArrayList<String> list = new ArrayList<String>();
        while(reader.hasNextLine()) {
         String line = reader.nextLine();
        list.add(line);
        }
        reader.close();

        return list;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
               
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file, false);
        for(String s : texts) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}
