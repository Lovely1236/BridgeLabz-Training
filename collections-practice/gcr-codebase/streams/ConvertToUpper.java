package streams;
import java.io.*;

public class ConvertToUpper {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str.toUpperCase());
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Operation Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}