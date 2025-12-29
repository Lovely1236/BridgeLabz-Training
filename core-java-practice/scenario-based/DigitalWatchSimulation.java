public class DigitalWatchSimulation{
    public static void main(String[] args){
        System.out.println("⏱️ Digital Watch Simulation Started");
        for(int hr=0;hr<24;hr++){        // Outer loop for hours (0–23)
            for (int min=0;min<60;min++){             // Inner loop for minutes (0–59)
                if(hr==13 && min==0){                      // Stop the watch at 13:00 (power cut)
                    System.out.println("⚡ Power cut at 13:00!");
                    break;
                }
                System.out.printf("%02d:%02d\n", hr, min);                   // Print time in HH:MM format
            }
            if(hr==13){               // Break outer loop as well when power cut happens
                break;
            }
        }
        System.out.println("⏹️ Oops...Watch stopped.");
    }
}
