class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pickUp = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> dropOff = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for(int[] trip: trips){
            pickUp.offer(new int[]{trip[0], trip[1], trip[2]});
        }

        int time = 0;
        int currCap = 0; 
        while(!pickUp.isEmpty() || !dropOff.isEmpty()){
            while(!dropOff.isEmpty() && dropOff.peek()[2] == time){
                int[] tmpDrop = dropOff.poll();
                currCap -= tmpDrop[0];
            }

            while(!pickUp.isEmpty() && pickUp.peek()[1] == time){
                if(currCap + pickUp.peek()[0] > capacity){
                    return false;
                }
                int[] tmpPick = pickUp.poll();
                currCap += tmpPick[0];
                dropOff.offer(new int[]{tmpPick[0], tmpPick[1], tmpPick[2]});
            }

            time++;
        }

        return true;
    }


}