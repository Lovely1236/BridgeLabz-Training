package streamApi;
import java.util.*;
class Doctor {
    String name;
    String specialty;
    boolean weekendAvailable;
    Doctor(String name,String specialty,boolean weekendAvailable){
        this.name=name;
        this.specialty=specialty;
        this.weekendAvailable=weekendAvailable;
    }
    public boolean isWeekendAvailable(){
        return weekendAvailable;
    }
    public String getSpecialty(){
        return specialty;
    }
    public String toString(){
        return name+" | "+specialty;
    }
}

public class Hospital {
    public static void main(String[] args){
        List<Doctor> doctors=List.of(
            new Doctor("Dr.Rahul","Cardiology",true),
            new Doctor("Dr.Anita","Neurology",false),
            new Doctor("Dr.Suresh","Orthopedic",true),
            new Doctor("Dr.Meena","Dermatology",true)
        );
        doctors.stream()
            .filter(d->d.isWeekendAvailable())
            .sorted((a,b)->a.getSpecialty().compareTo(b.getSpecialty()))
            .forEach(System.out::println);
    }
}