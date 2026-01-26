package streams;
import java.io.*;
public class FileCopy{
    public static void main(String[] args) {
        String sourceFile="data.txt";
        String destinationFile="output.txt";
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(sourceFile);
            fos=new FileOutputStream(destinationFile);
            int data;
            while((data=fis.read())!=-1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch(FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) fis.close();
                if(fos!=null) fos.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}