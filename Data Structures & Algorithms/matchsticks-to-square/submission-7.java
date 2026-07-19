class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4){
            return false;
        }
        int totalLength = Arrays.stream(matchsticks).sum();
        if(totalLength % 4 != 0){
            return false;
        }
        int targetLength = totalLength / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return backtrack(matchsticks, new int[4], 0, targetLength);
    }

    public boolean backtrack(int[] matchsticks, int[] sides, int index, int targetLength){
        if(index == matchsticks.length){
            return true;
        }

        for(int i = 0; i < sides.length; i++){
            if(sides[i] + matchsticks[index] <= targetLength){
                sides[i] += matchsticks[index];
                if(backtrack(matchsticks, sides, index + 1, targetLength)) return true;
                sides[i] -= matchsticks[index];
            }

            if(sides[i] == 0) break;
        }

        return false;
    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }

}