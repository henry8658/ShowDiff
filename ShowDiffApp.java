import java.io.*;

public class ShowDiffApp {
    private static final String OUTPUT = "output.txt";

    public static void main(String [] args) {
        ShowDiffApp app = new ShowDiffApp();
        String file1_path = args[0];
        String file2_path = args[1];
        app.compare(file1_path, file2_path, OUTPUT);
    }

    public ShowDiffApp() {

    }

    public void compare(String input1, String input2, String output) {
        BufferedReader bufferedReader1 = readfile(input1);
        BufferedReader bufferedReader2 = readfile(input2);
        BufferedWriter bufferedWriter = writeFile(output);

        String line2, line1 = null;

        try {
            while ((line1 = bufferedReader1.readLine()) != null && (line2 = bufferedReader2.readLine()) != null) {
                //System.out.println(line);
                bufferedWriter.write(line1);
                bufferedWriter.write(line2);

            }

            bufferedReader1.close();
            bufferedReader2.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader readfile(String input) {
        try {
            FileReader fileReader =
                 new FileReader(input);
            BufferedReader bufferedReader =
                 new BufferedReader(fileReader);
            return bufferedReader;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public BufferedWriter writeFile(String output) {
        try {
            FileWriter writer = new FileWriter(output, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            return bufferedWriter;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
