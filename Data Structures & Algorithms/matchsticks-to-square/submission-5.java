class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4){
            return false;
        }
        return backtrack(matchsticks, new int[]{matchsticks[0], 0, 0, 0}, 1);
    }

    public boolean backtrack(int[] matchsticks, int[] sides, int index){
        if(index == matchsticks.length){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        for(int i = 0; i < sides.length; i++){
            sides[i] += matchsticks[index];
            if(backtrack(matchsticks, sides, index + 1)) return true;
            sides[i] -= matchsticks[index];
        }

        return false;
    }

}