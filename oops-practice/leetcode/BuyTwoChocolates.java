class Solution {
    public int buyChoco(int[] prices, int money) {
        int ans=money;
        for(int i=1;i<prices.length;i++){
        if(prices[i-1]+ prices[i]<=money){
           if(prices[i-1]+ prices[i]==money) 
            return money-(prices[i-1]+ prices[i]);
        else
            ans = Math.max((money-(prices[i-1]+ prices[i])),ans);
        }
        }
        return ans;  
    }
}