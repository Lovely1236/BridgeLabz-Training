package streamApi;
import java.util.*;

public class SensorReadings {
    public static void main(String[] args){
        List<Integer> readings=List.of(45,78,90,30,100);
        int threshold=70;

        readings.stream()
            .filter(r->r>threshold)
            .forEach(r->System.out.println("High Reading:"+r));
    }
}