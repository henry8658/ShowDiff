import java.io.*;

public class regex {
    public static void main(String [] args) {

        String fileName1= "C:/Users/Henry/Desktop/Hello java.txt";
        try {
            FileReader fileReader =
                 new FileReader(fileName1);
            String line = null;
             // Always wrap FileReader in BufferedReader.
             BufferedReader objreader =
                 new BufferedReader(fileReader);

            while ((line = objreader.readLine()) != null) {
                System.out.println(line);
            }
            objreader.close();

        } catch(FileNotFoundException ex) {
            System.out.println("FilePath Not Found");
        } catch(IOException ex) {
            System.out.println("Error reading file");
        }
    }

}
