import java.io.*;

public class ShowDiffApp {
    private static final String OUTPUT = "output.txt";
    private static final String BOUNDARY = "==========\n";
    private static final String BOUNDARY2 = "----------\n";
    private static final String FILE1 = "FILE1:\n";
    private static final String FILE2 = "FILE2:\n";

    public static void main(String [] args) {
        ShowDiffApp app = new ShowDiffApp();
        String file1_path = args[0];
        String file2_path = args[1];
        app.run(file1_path, file2_path, OUTPUT);
    }

    public ShowDiffApp() {
    }

    public void run(String input1, String input2, String output) {
        BufferedReader bufferedReader1 = readfile(input1);
        BufferedReader bufferedReader2 = readfile(input2);
        BufferedWriter bufferedWriter = writeFile(output);

        try {
            handleComparison(bufferedWriter, bufferedReader1, bufferedReader2);

            bufferedReader1.close();
            bufferedReader2.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String leftOverLine(int file, String line, BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BOUNDARY);
        sb.append("FILE" + file + " LEFT:\n");
        sb.append(line + "\n");
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    private void handleLeftOver(String line1, String line2, BufferedWriter bufferedWriter, BufferedReader bufferedReader1, BufferedReader bufferedReader2) throws IOException {
        if (line1 != null) {
            bufferedWriter.write(leftOverLine(1, line1, bufferedReader1));
        } else if (line2 != null) {
            bufferedWriter.write(leftOverLine(2, line2, bufferedReader2));
        }
    }

    private void handleComparison(BufferedWriter bufferedWriter, BufferedReader bufferedReader1, BufferedReader bufferedReader2) throws IOException {
        String line1 = null;
        String line2 = null;
        while ((line1 = bufferedReader1.readLine()) != null
                && (line2 = bufferedReader2.readLine()) != null) {
            if (same(line1, line2)) {
                bufferedWriter.write(sameLine(line1));
            } else {
                bufferedWriter.write(differentLine(line1, line2));
            }
        }
        line2 = bufferedReader2.readLine();
        handleLeftOver(line1, line2, bufferedWriter, bufferedReader1, bufferedReader2);
    }

    private String differentLine(String line1, String line2) {
        StringBuilder sb = new StringBuilder();
        sb.append(BOUNDARY);
        sb.append(FILE1);
        sb.append(line1 + "\n");
        sb.append(BOUNDARY2);
        sb.append(FILE2);
        sb.append(line2 + "\n");
        sb.append(BOUNDARY);

        return sb.toString();
    }

    private String sameLine(String line) {
        return line + "\n";
    }

    private boolean same(String input1, String input2) {
        boolean same = false;

        if (input1.equals(input2)) {
            same = true;
        }
        return same;
    }

    private BufferedReader readfile(String input) {
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

    private BufferedWriter writeFile(String output) {
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
