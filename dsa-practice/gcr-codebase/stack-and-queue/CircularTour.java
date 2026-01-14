import java.util.*;
public class CircularTour {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of petrol pumps:");
        int n=ob.nextInt();
        int petrol[]=new int[n];
        int distance[]=new int[n];
        System.out.println("Enter petrol at each pump:");
        for(int i=0;i<n;i++)
            petrol[i]=ob.nextInt();
        System.out.println("Enter distance to next pump:");
        for(int i=0;i<n;i++)
            distance[i]=ob.nextInt();
        int startIndex=findStartingPoint(petrol,distance);
        if(startIndex==-1)
            System.out.println("Circular tour not possible");
        else
            System.out.println("Start tour from petrol pump index:"+startIndex);
    }
    public static int findStartingPoint(int petrol[],int distance[]){
        int currentPetrol=0;
        int deficit=0;
        int start=0;
        for(int i=0;i<petrol.length;i++){
            currentPetrol+=petrol[i]-distance[i];
            if(currentPetrol<0){
                deficit+=currentPetrol;
                start=i+1;
                currentPetrol=0;
            }
        }
        if(currentPetrol+deficit>=0)
            return start;
        else
            return -1;
    }
}