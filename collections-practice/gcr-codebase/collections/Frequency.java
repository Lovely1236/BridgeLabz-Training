package collections;
import java.util.*;
public class Frequency {
    public static void main(String[] args) {
        Scanner ob=new Scanner (System.in);
        System.out.print("Enter number of elements: ");
        int n=ob.nextInt();
        List<String> list=new ArrayList<>();
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){   
            list.add(ob.next());
        }
        FrequencyCounter.countFrequency(list);
    }
}
class FrequencyCounter{
    public static void countFrequency(List<String> list){
        HashMap<String,Integer> freqMap=new HashMap<>();
        for(String s:list){
            freqMap.put(s,freqMap.getOrDefault(s,0)+1);
        }
        System.out.println(freqMap);
    }
}