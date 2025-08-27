class Solution {
    int dirs[][] = {{-1,1},{1,1},{1,-1},{-1,-1}};
    int [][] grid;
    int row, col;   

    public int lenOfVDiagonal(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        int res = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    res = Math.max(res, 1);
                    for(int d = 0; d < 4; d++) {
                        //row , col , direction , target , isTurned
                        res = Math.max(res, dfs(i, j, d, 2,false));
                    }
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j , int dir ,int target, boolean isTurned){
        int x = i + dirs[dir][0];//next position
        int y = j + dirs[dir][1];//next position

        //  x and y in boundarys and that posion is target
        if(x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != target) return 1;

        int straight = 1 + dfs(x, y, dir, target == 2 ? 0: 2, isTurned);//continue in the same direction

        int turn = 0; //length after turn
        if(!isTurned) { //can turn only once
            // dir + 1 --> 90deg turn
            turn = 1 + dfs(x, y, (dir + 1) % 4, target == 2 ? 0: 2, true);
        }
        return Math.max(straight, turn);
    }
}
