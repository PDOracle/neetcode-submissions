class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        preSum = new int[rows + 1][cols + 1];

        for(int i = 0; i < rows; i++){
            int prefix = 0;
            for(int j = 0; j < cols; j++){
                prefix += matrix[i][j];
                int above = preSum[i][j + 1];
                preSum[i + 1][j + 1] = prefix + above;
            }
        }    
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        int bRight = preSum[row2][col2];
        int aboveTop = preSum[row1 - 1][col2];
        int left = preSum[row2][col1 - 1];
        int tLeft = preSum[row1 - 1][col1 - 1];
        return bRight - aboveTop - left + tLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */