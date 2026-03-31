import java.util.*;
public class TemperatureAnalyzer{
    static void analyzeTemperature(float[][] temperatures){
        float hottestDayAvg=0;
        float coldestDayAvg=0;
        int hottestDay=0;
        int coldestDay=0;
        for(int day=0;day<7;day++){
            float sum=0;
            for(int hour=0;hour<24;hour++){
                sum+=temperatures[day][hour];
            }
            float average=sum/24;
            System.out.println("Average temperature of Day "+(day+1)+": "+average);
            if(day==0){
                hottestDayAvg=average;
                coldestDayAvg=average;
            }
            if(average>hottestDayAvg){
                hottestDayAvg=average;
                hottestDay=day;
            }
            if(average<coldestDayAvg){
                coldestDayAvg=average;
                coldestDay=day;
            }
        }
        System.out.println("Hottest Day: Day "+(hottestDay+1));
        System.out.println("Coldest Day: Day "+(coldestDay+1));
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        float[][] temperatures=new float[7][24];
        for(int day=0;day<7;day++){
            System.out.println("Enter temperatures for Day "+(day+1));
            for(int hour=0;hour<24;hour++){
                System.out.print("Hour "+(hour+1)+": ");
                temperatures[day][hour]=ob.nextFloat();
            }
        }
        analyzeTemperature(temperatures);
    }
}