class Solution {
    public int[] plusOne(int[] digits) {
        int lastIndx= digits.length-1;

        // this while condition is for the case when only 9 is given 
        // or the cases like 99, 999,9999
        while(lastIndx>=0 && digits[lastIndx]==9){
            digits[lastIndx--]= 0;

        }
        //this executes when our arr contains 9, 99, 999,9999 like cases 
        //where the index comes in negative
        if(lastIndx<0){

            //for cases like that we insert one at the begining in the 
            //new array and return that new array
            int[] newArr = new int[digits.length+1];
            newArr[0]=1;
            System.arraycopy(digits,0, newArr,1, digits.length);
            return newArr;
        }

        // this part executes of all the cases where our index doesn't
        // go in negative and where we don't have to insert anything 
        //in begining..instead we have to increment the front digit
        else{
            digits[lastIndx]++;
        }
        return digits;
    }
}