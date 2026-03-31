package collectors;
import java.util.*;
import java.util.stream.*;

public class WordFrequencyApp{
    public static void main(String[] args){
        String text="java stream makes java powerful";
        Map<String,Integer> freq=Arrays.stream(text.split(" ")).collect(Collectors.toMap(w->w,w->1,Integer::sum));
        System.out.println(freq);
    }
}