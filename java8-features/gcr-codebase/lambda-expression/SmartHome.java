package lambda_expression;
@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHome {
    public static void main(String[] args) {

        
        LightAction motionLight = () -> 
            System.out.println("Motion detected → Lights ON at full brightness");

    
        LightAction nightLight = () -> 
            System.out.println("Night mode → Dim lights activated");

     
        LightAction voiceLight = () -> 
            System.out.println("Voice command → Party lights ON");

       
        motionLight.activate();
        nightLight.activate();
        voiceLight.activate();
    }
}
