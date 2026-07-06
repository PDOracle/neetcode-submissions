class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private int rows, cols;
    
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return dfs(i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int row, int col){
        if(row < 0 || col < 0 || row >= rows || 
        col >= cols || grid[row][col] == 0){ //works without index error as we verify those conditions before the last one in the statement
            return 1;
        }
        
        if(visited[row][col]){
            return 0;
        }

        visited[row][col] = true;

        return dfs(row + 1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1);
    } 
}