package functional_interface;

interface Device{
	void turnOn();
	void turnOff();
}

class Light implements Device{
	public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class AC implements Device{
	public void turnOn() {
        System.out.println("AC is ON");
    }

    public void turnOff() {
        System.out.println("AC is OFF");
    }
}

class TV implements Device{
	public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }
}


public class SmartDevice {
	public static void main(String[] args) {
		Device light =new Light();
		Device ac =new AC();
		Device tv =new TV();
		
		light.turnOn();
		ac.turnOn();
		tv.turnOn();
		
		light.turnOff();
		ac.turnOff();
		tv.turnOff();
	}
}
