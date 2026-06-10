class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    int[][] state = new int[board.length][board[0].length];

                    boolean found = sol(board, word, "", state, j, i);
                    if(found){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean sol(char[][] board, String word, String curr, int[][] state, int x, int y){
        if(x > board[0].length - 1 || y > board.length - 1 || x < 0 || y < 0){
            return false;
        }
        if(word.indexOf(curr) != 0){
            return false;
        }
        if(state[y][x] == 1){
            return false;
        }
        String newCurr = curr + board[y][x];
        int[][] newState = state.clone();
        newState[y][x] = 1;
        if(word.equals(newCurr)){
            return true;
        }
        boolean left = sol(board, word, newCurr, newState, x - 1, y);
        boolean right = sol(board, word, newCurr, newState, x + 1, y);
        boolean up = sol(board, word, newCurr, newState, x, y - 1);
        boolean down = sol(board, word, newCurr, newState, x, y + 1);
        newState[y][x] = 0;
        return left || right || up || down;
    }
}