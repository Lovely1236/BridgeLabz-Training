package gcr.csv;
import java.io.*;
public class CSVToJson {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("students.csv"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("students.json"));
        bw.write("[\n");
        br.readLine();
        String line;
        boolean first=true;
        while((line=br.readLine())!=null){
            String[] d=line.split(",");
            if(!first){
                bw.write(",\n");
            }
            bw.write("{\"id\":"+d[0]+",\"name\":\""+d[1]+"\",\"age\":"+d[2]+"}"
            );
            first=false;
        }
        bw.write("\n]");
        br.close();
        bw.close();
        System.out.println("CSV To JSON Done");
    }
}