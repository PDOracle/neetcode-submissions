class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] billsOnHand = new int[3]; //you don't need to track the 20s, but for the sake of clarity it will be here
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                billsOnHand[0]++;
            }
            else if(bills[i] == 10){
                billsOnHand[1]++;
                if(billsOnHand[0] == 0){
                    return false;
                }
                billsOnHand[0]--;
            }
            else{
                billsOnHand[2]++;
                if(billsOnHand[1] != 0 && billsOnHand[0] != 0){
                    billsOnHand[0]--;
                    billsOnHand[1]--;
                    continue;
                }
                else if(billsOnHand[0] > 2){
                    billsOnHand[0] -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}