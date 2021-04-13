import java.io.*;

public class Writer {

    private static FileWriter fileWriter;
    private static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileWriter = new FileWriter(new File("src/main/resources/output.csv"));
        }catch (IOException e) {
            System.out.println("Don't find file");
        }
    }

    public static void write(double x, double result, Modules modules) {
        try {
            System.out.println("Print a value for a module  " + modules.toString() + "? [y/n]");
            String answer = reader.readLine();
            if (answer == null) return;
            while (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("Wrong answer");
                answer = reader.readLine();
            }
            if (answer.equals("y")) {
                fileWriter.write(x + "," + result + ", module - " + modules.toString() + "\n");
                fileWriter.flush();
            }
        }catch (IOException e) {
            System.out.println("Something wrong with file");
        }
    }

    public static void close() {
        try {
            reader.close();
            fileWriter.close();
        }catch (IOException e) {
            System.out.println("Can't close streams");
        }
    }
}
