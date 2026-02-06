package runtime_analysis;
import java.io.*;
import java.util.*;
public class FileReadComparision {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter full file path:");
        String path=ob.nextLine();
        performanceTest(path);
    }
    public static void performanceTest(String path){
        // FileReader Test
        long start1=System.nanoTime();
        long chars1=readUsingFileReader(path);
        long end1=System.nanoTime();
        // InputStreamReader Test
        long start2=System.nanoTime();
        long chars2=readUsingInputStreamReader(path);
        long end2=System.nanoTime();
        System.out.println("FileReader Characters Read: "+chars1);
        System.out.println("FileReader Time (ms): "+((end1-start1)/1000000));
        System.out.println("InputStreamReader Characters Read: "+chars2);
        System.out.println("InputStreamReader Time (ms): "+((end2-start2)/1000000));
    }
    public static long readUsingFileReader(String path){
        long count=0;
        try{
            FileReader fr=new FileReader("Sample.txt");
            int ch;
            while((ch=fr.read())!=-1){
                count++;
            }
            fr.close();
        }
        catch(Exception e){
            System.out.println("Error reading file using FileReader: "+e.getMessage());
        }
        return count;
    }
    public static long readUsingInputStreamReader(String path){
        long count=0;
        try{
            FileInputStream fis=new FileInputStream("sample.txt");
            InputStreamReader isr=new InputStreamReader(fis);
            int ch;
            while((ch=isr.read())!=-1){
                count++;
            }
            isr.close();
            fis.close();
        }
        catch(Exception e){
            System.out.println("Error reading file using InputStreamReader: "+e.getMessage());
        }
        return count;
    }
}