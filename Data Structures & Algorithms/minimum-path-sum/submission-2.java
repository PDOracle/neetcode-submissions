class Solution {
    public int[][] memo;

    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                memo[i][j] = -1;
            }
        }
        return dp(0, 0, grid);
    }

    public int dp(int row, int col, int[][] grid){
        if(row == grid.length - 1 && col == grid[0].length - 1){
            return grid[row][col];
        }
        if(row == grid.length || col == grid[0].length){
            return Integer.MAX_VALUE; 
        }
        if (memo[row][col] != -1){
            return memo[row][col];
        }
        memo[row][col] = grid[row][col] + Math.min(dp(row + 1, col, grid), dp(row, col + 1, grid)); 
        return memo[row][col];
    }
}