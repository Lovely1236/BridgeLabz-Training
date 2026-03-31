package linear_binary_search;
import java.io.*;
import java.util.*;
public class ChallengeProblem {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Compare Time of StringBuilder and StringBuffer");   
        System.out.println("2. Write to File");
        System.out.println("3. Read from File");
        int n=ob.nextInt();
        ob.nextLine();
        switch(n){
            case 1:
                compareTime(ob);
                break;
            case 2:
                fileWrite();
                break;
            case 3:
                fileRead();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    public static void compareTime(Scanner ob){
        System.out.println("Enter the String to compare time");
        String str=ob.nextLine();
        builder(str);
        buffer(str);
    }
    public static void builder(String str){
        StringBuilder sb=new StringBuilder();
        double start=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append(str);
        }
        double end=System.nanoTime();
        double timeTaken=end-start;
        System.out.println("Time taken by StringBuilder: "+timeTaken+" nanoseconds");
    }
    public static void buffer(String str){
        StringBuffer sb=new StringBuffer();
        double start=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append(str);
        }
        double end=System.nanoTime();
        double timeTaken=end-start;
        System.out.println("Time taken by StringBuffer: "+timeTaken+" nanoseconds");
    }
    public static void fileWrite(){
        FileWriter writer = null;
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);
            System.out.println("Enter text to write to file (type 'exit' to finish)");
            writer = new FileWriter("output.txt");
            String line;
            while((line=reader.readLine())!=null){
                if(line.equalsIgnoreCase("exit")){
                    break;
                }
                writer.write(line);
                writer.write("\n");
                System.out.println("Line added to file");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    }
        public static void fileRead(){
            BufferedReader reader = null;
        try {
            FileReader read=new FileReader("sample.txt");
            reader = new BufferedReader(read);
            String line="";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader: " + e.getMessage());
            }
        }
    }
}
    