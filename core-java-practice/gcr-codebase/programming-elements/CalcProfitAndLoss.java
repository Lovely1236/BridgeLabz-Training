public class CalcProfitAndLoss {
    public static void main(String[] args) {
        double cp = 129.0;

        double sp = 191.0;


        if (sp > cp) {


            double profitPrice = sp - cp;
            double profitPercent = (profitPrice / cp) * 100;
            
            System.out.println("The Cost Price is INR:" + cp + ", Selling Price is INR:" + sp);

            System.out.println("The Profit is INR: " + profitPrice + " and the Profit Percentage is: " + profitPercent + "%");


        } else if (cp > sp) {
            double lossPrice = cp - sp;


            System.out.println("Loss: " + lossPrice);
        } else {
            System.out.println("No Profit No Loss");
        }
    }
}
