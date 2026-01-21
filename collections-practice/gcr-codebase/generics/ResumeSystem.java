package generics;
import java.util.*;
abstract class JobRole {
    String roleName;
    JobRole(String name){
        this.roleName=name;
    }
}
class SoftwareEngineer extends JobRole {
    SoftwareEngineer(){
        super("Software Engineer");
    }
}
class DataScientist extends JobRole {
    DataScientist(){
        super("Data Scientist");
    }
}
class ProductManager extends JobRole {
    ProductManager(){
        super("Product Manager");
    }
}
class Resume<T extends JobRole> {
    T role;
    String candidateName;
    Resume(String name,T role){
        this.candidateName=name;
        this.role=role;
    }
    public void display(){
        System.out.println("Candidate: "+candidateName+" | Role: "+role.roleName);
    }
    public static void screenAll(List<? extends Resume<?>> list){
        System.out.println("Screening Results:");
        for(Resume<?> r:list){
            r.display();
        }
    }
}
public class ResumeSystem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Resume<?>> resumes=new ArrayList<>();
        System.out.print("Enter number of candidates: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter candidate name: ");
            String name=sc.nextLine();
            System.out.print("Enter role(Software/Data/Product): ");
            String role=sc.nextLine();
            if(role.equalsIgnoreCase("Software")){
                resumes.add(new Resume<>(name,new SoftwareEngineer()));
            }else if(role.equalsIgnoreCase("Data")){
                resumes.add(new Resume<>(name,new DataScientist()));
            }else if(role.equalsIgnoreCase("Product")){
                resumes.add(new Resume<>(name,new ProductManager()));
            }
        }
        Resume.screenAll(resumes);
    }
}