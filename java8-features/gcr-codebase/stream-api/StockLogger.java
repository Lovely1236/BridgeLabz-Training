package streamApi;
import java.util.*;

public class StockLogger {
    public static void main(String[] args){
        List<Double> prices=List.of(102.5,104.2,101.8,105.6);

        prices.forEach(p->System.out.println("Stock Price:"+p));
    }
}