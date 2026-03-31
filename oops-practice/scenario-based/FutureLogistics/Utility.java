package FutureLogistic;
public class Utility {

    public static boolean validateTransportId(String transportId) {
        if(transportId==null||transportId.length()!=7) {
            System.out.println("Transport id "+transportId+" is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }

        if(!transportId.startsWith("RTS")) {
            System.out.println("Transport id "+transportId+" is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }

        for(int i=3;i<6;i++) {
            if(!Character.isDigit(transportId.charAt(i))) {
                System.out.println("Transport id "+transportId+" is invalid");
                System.out.println("Please provide a valid record");
                return false;
            }
        }

        char last=transportId.charAt(6);
        if(!Character.isUpperCase(last)) {
            System.out.println("Transport id "+transportId+" is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }

        return true;
    }

    public static GoodsTransport parseDetails(String input) {
        String[] data=input.split(":");

        String transportId=data[0];
        String transportDate=data[1];
        int transportRating=Integer.parseInt(data[2]);
        String transportType=data[3];

        if(!validateTransportId(transportId)) {
            return null;
        }

        if(transportType.equalsIgnoreCase("BrickTransport")) {
            float brickSize=Float.parseFloat(data[4]);
            int brickQuantity=Integer.parseInt(data[5]);
            float brickPrice=Float.parseFloat(data[6]);

            return new BrickTransport(transportId,transportDate,transportRating,brickSize,brickQuantity,brickPrice);
        } else if(transportType.equalsIgnoreCase("TimberTransport")) {
            float timberLength=Float.parseFloat(data[4]);
            float timberRadius=Float.parseFloat(data[5]);
            String timberType=data[6];
            float timberPrice=Float.parseFloat(data[7]);

            return new TimberTransport(transportId,transportDate,transportRating,timberLength,timberRadius,timberType,timberPrice);
        }

        return null;
    }

    public static String findObjectType(GoodsTransport goodsTransport) {
        if(goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        } else if(goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }
        return "";
    }
}