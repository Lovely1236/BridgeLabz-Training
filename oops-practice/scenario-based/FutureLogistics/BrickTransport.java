package FutureLogistic;
public class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId,String transportDate,int transportRating,float brickSize,int brickQuantity,float brickPrice) {
        super(transportId,transportDate,transportRating);
        this.brickSize=brickSize;
        this.brickQuantity=brickQuantity;
        this.brickPrice=brickPrice;
    }

    public float getBrickSize() {
        return brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public void setBrickSize(float brickSize) {
        this.brickSize=brickSize;
    }

    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity=brickQuantity;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice=brickPrice;
    }

    public String vehicleSelection() {
        if(brickQuantity<300) {
            return "Truck";
        } else if(brickQuantity>=300&&brickQuantity<=500) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }

    public float calculateTotalCharge() {
        float price=brickPrice*brickQuantity;
        float tax=price*0.3f;

        float discount=0;
        if(transportRating==5) {
            discount=price*0.20f;
        } else if(transportRating==3||transportRating==4) {
            discount=price*0.10f;
        }

        float vehiclePrice=getVehiclePrice(vehicleSelection());
        return (price+vehiclePrice+tax)-discount;
    }

    private float getVehiclePrice(String vehicle) {
        if(vehicle.equalsIgnoreCase("Truck")) {
            return 1000;
        } else if(vehicle.equalsIgnoreCase("Lorry")) {
            return 1700;
        } else {
            return 3000;
        }
    }
}