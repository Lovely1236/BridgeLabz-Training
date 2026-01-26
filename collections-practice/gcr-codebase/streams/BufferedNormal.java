package streams;
import java.io.*;
public class BufferedNormal {
    private static final int BUFFER_SIZE=4096;
    public static void main(String[] args) throws IOException {
        String source="data.txt";
        String normalCopy="output.txt";
        String bufferedCopy="bufferedCopy.txt";
        long normalTime=copyNormal(source,normalCopy);
        long bufferedTime=copyBuffered(source,bufferedCopy);
        System.out.println("Normal Stream Time:"+normalTime+" ns");
        System.out.println("Buffered Stream Time:"+bufferedTime+" ns");
    }
    private static long copyNormal(String src,String dest) throws IOException {
        FileInputStream fis=new FileInputStream(src);
        FileOutputStream fos=new FileOutputStream(dest);
        byte[] buffer=new byte[BUFFER_SIZE];
        int bytesRead;
        long start=System.nanoTime();
        while((bytesRead=fis.read(buffer))!=-1) {
            fos.write(buffer,0,bytesRead);
        }
        long end=System.nanoTime();
        fis.close();
        fos.close();
        return end-start;
    }
    private static long copyBuffered(String src,String dest) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(dest));
        byte[] buffer=new byte[BUFFER_SIZE];
        int bytesRead;
        long start=System.nanoTime();
        while((bytesRead=bis.read(buffer))!=-1) {
            bos.write(buffer,0,bytesRead);
        }
        long end=System.nanoTime();
        bis.close();
        bos.close();
        return end-start;
    }
}