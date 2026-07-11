class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int astRem = 0;
        Stack<Integer> ast = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            if(ast.empty()){
                astRem++;
                ast.push(asteroids[i]);
            }
            else{
                int dirP = ast.peek() < 0 ? -1 : 1;
                int dirN = asteroids[i] < 0 ? -1 : 1;

                if(dirP == -1 || dirP == dirN){
                    astRem++;
                    ast.push(asteroids[i]);
                }
                else{
                    boolean col = true;
                    boolean astInt = true;
                    while(col && astInt){
                        col = false;
                        if(ast.empty()){
                            break;
                        }
                        dirP = ast.peek() < 0 ? -1 : 1;
                        if(dirP == -1 || dirP == dirN){
                            break;
                        }
                        if(ast.peek() < Math.abs(asteroids[i])){
                            col = true;
                            astRem--;
                            ast.pop();
                        }
                        else if(ast.peek() == Math.abs(asteroids[i])){
                            ast.pop();
                            astRem--;
                            astInt = false;
                        }
                        else{
                            astInt = false;
                        }
                    }
                    if(astInt){
                        astRem++;
                        ast.push(asteroids[i]);
                    }
                }
            }
        }

        int[] res = new int[astRem];
        System.out.println(astRem);
        for(int j = res.length - 1; j > -1; j--){
            res[j] = ast.pop();
        }
        return res;
    }
}