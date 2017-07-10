import java.io.*;

public class ShowDiffApp {
    public static void main(String [] args) {
        ShowDiffApp app = new ShowDiffApp();
        app.readfile("C:/Users/Henry/Desktop/Hello java.txt");
    }

    public ShowDiffApp() {

    }

    public void readfile(String filepath) {

        try {
            String line = null;
            FileReader fileReader =
                 new FileReader(filepath);
            BufferedReader objreader =
                 new BufferedReader(fileReader);

            while ((line = objreader.readLine()) != null) {
                System.out.println(line);
            }
            objreader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("FilePath Not Found");
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }
}
