import java.util.Scanner;

public class EmployBonusCalculation{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    double[] salary = new double[10];
    double[] years = new double[10];
    double[] bonus = new double[10];
    double[] newSalary = new double[10];

    double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

    // Input loop
    
    for(int i=0;i<10;i++){
        
      System.out.println("Enter details for the Employee " + (i + 1));

      
      // Salary input validation
      
      System.out.print("Enter Salary--> ");
      double s = sc.nextDouble();
      
      if(s<= 0){
          
        System.out.println("Invalid salary! Please enter again.");
        
        i--; // decrement index to retry
        continue;
      }

      // Years of service input validation
      
      System.out.print("Enter Years of Service: ");
      double y = sc.nextDouble();
      if(y<0){
          
        System.out.println("Invalid years of service! Please enter again.");
        
        i--; // decrementing index for retrying
        continue;
      }
      
      
      salary[i]=s;
      years[i]=y;
      
    }
    
    // Calculation loop
    
    for(int i=0;i<10;i++){
        
      if(years[i]> 5){
          
        bonus[i] = salary[i] * 0.05; // 5% bonus
      } 
      else{
          
        bonus[i] = salary[i] * 0.02; // 2% bonus
      }

      newSalary[i] = salary[i] + bonus[i];

      totalBonus += bonus[i];
      totalOldSalary += salary[i];
      totalNewSalary += newSalary[i];
      
    }

    System.out.println("Total Old Salary: " + totalOldSalary);
    System.out.println("Total Bonus Payout: " + totalBonus);
    System.out.println("Total New Salary: " + totalNewSalary);

    sc.close();
  }
}