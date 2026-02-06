package scenario_based;
import java.util.*;

class InvalidFlightException extends Exception{
    public InvalidFlightException(String message){
        super(message);
    }
}

class FlightUtil{

    public boolean validateFlightNumber(String flightNumber)throws InvalidFlightException{
        if(flightNumber==null||!flightNumber.matches("FL-[1-9][0-9]{3}")){
            throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName)throws InvalidFlightException{
        if(!(flightName.equals("SpiceJet")||flightName.equals("Vistara")||flightName.equals("IndiGo")||flightName.equals("Air Arabia"))){
            throw new InvalidFlightException("The flight name "+flightName+" is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount,String flightName)throws InvalidFlightException{
        int max=0;
        if(flightName.equals("SpiceJet")) max=396;
        else if(flightName.equals("Vistara")) max=615;
        else if(flightName.equals("IndiGo")) max=230;
        else if(flightName.equals("Air Arabia")) max=130;
        if(passengerCount<=0||passengerCount>max){
            throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName,double currentFuelLevel)throws InvalidFlightException{
        double capacity=0;
        if(flightName.equals("SpiceJet")) capacity=200000;
        else if(flightName.equals("Vistara")) capacity=300000;
        else if(flightName.equals("IndiGo")) capacity=250000;
        else if(flightName.equals("Air Arabia")) capacity=150000;
        if(currentFuelLevel<0||currentFuelLevel>capacity){
            throw new InvalidFlightException("Invalid fuel level for "+flightName);
        }
        return capacity-currentFuelLevel;
    }
}

public class AeroVigil{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        FlightUtil util=new FlightUtil();
        System.out.println("Enter flight details");
        String input=sc.nextLine();
        try{
            String[] parts=input.split(":");
            String flightNumber=parts[0];
            String flightName=parts[1];
            int passengerCount=Integer.parseInt(parts[2]);
            double currentFuelLevel=Double.parseDouble(parts[3]);
            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount,flightName);
            double fuel=util.calculateFuelToFillTank(flightName,currentFuelLevel);
            System.out.println("Fuel required to fill the tank: "+fuel+" liters");
        }catch(InvalidFlightException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Invalid input format");
        }
    }
}